package JDBC;

import org.junit.Test;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.*;

/**
 * @author pzy
 * @create 2023-10-29-17:11
 * @function preparedStatement的CRUD操作
 * 1.preparedStatement可以解决Statement的拼串，sql注入问题
 * 2.preparedStatement可以操作Blob数据，而Statement做不到
 * 3.preparedStatement可以实现更高效的批量操作
 */
public class PreparedStatement {
    @Test
//向jdbc的test表中插入一条数据
    public void testInsert() {
        Connection connection = null;
        java.sql.PreparedStatement ps = null;
        try {
//        1.读取配置文件中的四个基本信息
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
            Properties properties = new Properties();
            properties.load(is);
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            String url = properties.getProperty("url");
            String driverClass = properties.getProperty("driverClass");
//        2.加载驱动
            Class.forName(driverClass);
//        3.获取连接
            connection = DriverManager.getConnection(url, user, password);
//        System.out.println(connection);
//        4.预编译sql语句，返回PreparedStatement实例
            String sql = "insert into test(name,sex)values(?,?)";//?占位符
            ps = connection.prepareStatement(sql);
//        5.填充占位符
            ps.setString(1, "杨世");
            ps.setString(2, "男");
//        6.执行sql操作
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
//        7.资源的关闭
            try {
                if (ps != null) ps.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                if (connection != null) connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Test
//修改test表的一条记录
    public void testUpdate() {
        Connection connection = null;
        java.sql.PreparedStatement ps = null;
        try {
//        1.获取数据库的连接
            connection = JDBCUtils.getConnection();
//        2.预编译sql语句，返回PreparedStatement的实例
            String sql = "update test set name = ? where id = ?";
            ps = connection.prepareStatement(sql);
//        3.填充占位符
            ps.setString(1, "李涛");
            ps.setString(2, "12");
//        4.执行
            ps.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
//        5.资源的关闭
            JDBCUtils.closeResource(connection, ps);
        }
    }

    //    通用的增删改操作
    public void update(String sql, Object... args) {
        Connection connection = null;
        java.sql.PreparedStatement ps = null;
        try {
//        1.获取数据库的连接
            connection = JDBCUtils.getConnection();
//        2.预编译sql语句，返回PreparedStatement的实例
            ps = connection.prepareStatement(sql);
//        3.填充占位符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
//        4.执行
            ps.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
//        5.资源的关闭
            JDBCUtils.closeResource(connection, ps);
        }
    }

    @Test
//    测试通用的增删改操作
    public void testCommonUpdate() {
//        String sql = "delete from test where id = ?;";
        String sql = "update test set sex = ? where name = ?;";
        update(sql, "女", "张俊");
    }

    @Test
//    查询操作
    public void QueryTest() {
        Connection connection = null;
        java.sql.PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection();
//            sql语句中有占位符记得填充占位符
            String sql = "select id,name,sex,picture from test";
            ps = connection.prepareStatement(sql);
//        执行并返回结果集
            resultSet = ps.executeQuery();
//        处理结果集
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String sex = resultSet.getString(3);
                Blob picture = resultSet.getBlob(4);
                testClass testClass = new testClass(id, name, sex, picture);
                System.out.println(testClass);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.closeResourceQuery(connection, ps, resultSet);
        }
    }

    //    通用查询操作
    public void Query(String sql, Object obj, Object... args) {
        Connection connection = null;
        java.sql.PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
//        1.获取连接
            connection = JDBCUtils.getConnection();
            ps = connection.prepareStatement(sql);
            if (args.length != 0) {
                for (int i = 0; i < args.length; i++) {
                    ps.setObject(i + 1, args[i]);
                }
            }
            resultSet = ps.executeQuery();
//            获取结果集的原数据 ResultSetMetaData
            ResultSetMetaData metaData = resultSet.getMetaData();
//            通过 ResultSetMetaData 获取结果集中的列数
            int columnCount = metaData.getColumnCount();
//            testClass testClass = new testClass();
            while (resultSet.next()) {
                for (int i = 0; i < columnCount; i++) {
                    //                获取列名 getColumnName,获取列的别名 getColumnLabel
                    String columnName = metaData.getColumnLabel(i + 1);
                    Object columnValue = resultSet.getObject(i + 1);
                    //                通过反射获取指定的属性名
                    Field field = obj.getClass().getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(obj, columnValue);
                }
                System.out.println(obj);

            }
//            return testClass;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.closeResourceQuery(connection, ps, resultSet);
        }
//        return null;
    }

    @Test
    public void test() {
        String sql = "select id,name,sex from test where id = ?;";
        testClass testClass = new testClass();
        Query(sql, testClass, "12");
//        System.out.println(query);
    }

    //    在通用查询操作基础上，将数据放入集合中
    public List<Object> Query1(String sql, Object obj, Object... args) {
        Connection connection = null;
        java.sql.PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
//        1.获取连接
            connection = JDBCUtils.getConnection();
            ps = connection.prepareStatement(sql);
            if (args.length != 0) {
                for (int i = 0; i < args.length; i++) {
                    ps.setObject(i + 1, args[i]);
                }
            }
            resultSet = ps.executeQuery();
//            获取结果集的原数据 ResultSetMetaData
            ResultSetMetaData metaData = resultSet.getMetaData();
//            通过 ResultSetMetaData 获取结果集中的列数
            int columnCount = metaData.getColumnCount();
            ArrayList<Object> objects = new ArrayList<>();
            while (resultSet.next()) {
                String a = null;
                for (int i = 0; i < columnCount; i++) {
//                获取列名 getColumnName,获取列的别名 getColumnLabel
                    String columnName = metaData.getColumnLabel(i + 1);
                    Object columnValue = resultSet.getObject(i + 1);
//                通过反射获取指定的属性名
                    Field field = obj.getClass().getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(obj, columnValue);
                    a = obj.toString();
                }
                objects.add(a);
//                System.out.println(obj);
            }
            return objects;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.closeResourceQuery(connection, ps, resultSet);
        }
    }

    @Test
    public void test1() {
        String sql = "select id,name,sex from test;";
        testClass testClass = new testClass();
        List<Object> objects = Query1(sql, testClass);
        System.out.println(objects);
    }
}

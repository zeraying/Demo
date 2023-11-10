package JDBC;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author pzy
 * @create 2023-10-29-17:51
 * @function 操作数据库的工具类
 */
public class JDBCUtils {
    //    获取数据库的连接
    public static Connection getConnection() throws Exception {
//        1.读取配置文件中的四个基本信息
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
//        Properties该类主要用于读取Java的配置文件
        Properties properties = new Properties();
        properties.load(is);
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driverClass = properties.getProperty("driverClass");
//        2.加载驱动
        Class.forName(driverClass);
//        3.获取连接
        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }

    //    关闭连接和Statement操作
    public static void closeResource(Connection connection, Statement ps) {
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

    public static void closeResourceQuery(Connection connection, Statement ps, ResultSet resultSet) {
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
        try {
            if (resultSet != null) resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

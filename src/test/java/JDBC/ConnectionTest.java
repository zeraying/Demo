package JDBC;

import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author pzy
 * @create 2023-10-26-10:49
 * @function 测试连接
 */
public class ConnectionTest {
    //    方式一
    @Test
    public void testConnection1() throws SQLException {
        Driver driver = new com.mysql.cj.jdbc.Driver();
        String url = "jdbc:mysql://localhost:3306/housing_resources";
//        将用户名和密码封装在properties中
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "root123");
        Connection conn = driver.connect(url, info);
        System.out.println(conn);
    }

    //    方式二,在程序中不出现第三方的api使程序具有更好的可移植性
    @Test
    public void testConnection2() throws Exception {
//        1.获取Driver实现类对象，使用反射
        Class<?> clazz = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();
//        2.提供要连接的数据库
        String url = "jdbc:mysql://localhost:3306/housing_resources";
//        3.提供连接需要的用户名和密码
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "root123");
//        4.获取连接
        Connection conn = driver.connect(url, info);
        System.out.println(conn);
    }
    //    方式三，使用DriverManger替换Driver
    @Test
    public void testConnection3() throws Exception {
//        1.获取Driver实现类的对象
        Class<?> clazz = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();
//        2.提供连接的三个信息
        String url = "jdbc:mysql://localhost:3306/housing_resources";
        String user = "root";
        String password = "root123";
//        3.注册驱动
        DriverManager.registerDriver(driver);
//        4.获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);
    }
    //    方式四
    @Test
    public void testConnection4() throws Exception {
//        1.提供连接的三个信息
        String url = "jdbc:mysql://localhost:3306/housing_resources";
        String user = "root";
        String password = "root123";
//        2.获取Driver实现类的对象
        Class<?> clazz = Class.forName("com.mysql.cj.jdbc.Driver");
//        3.获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);
    }
//    方式五：将连接需要的4个基本信息声明在配置文件中，读取配置文件来获取连接。
    @Test
    public void testConnection5() throws Exception {
//        1.读取配置文件中的四个基本信息
        InputStream is = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
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
        System.out.println(connection);

    }
}

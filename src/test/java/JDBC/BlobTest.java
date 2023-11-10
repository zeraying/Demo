package JDBC;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author pzy
 * @create 2023-11-03-22:25
 * @function 二进制类型数据的操作
 */
public class BlobTest {
    @Test
//    将图片以输入流的形式传入数据库中
    public void InsertTest() {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "insert into test(id,name,sex,picture) values(?,?,?,?) ";
            ps = connection.prepareStatement(sql);
            File file = new File("C:\\Users\\Administrator\\Pictures\\壁纸");
            File[] files = file.listFiles();
            String name = null;
            String path = null;
            for (File file1 : files) {
                while (file1.getName().contains("薇恩.jpg")) {
                    name = file1.getName();
                    path = file1.getPath();
                    break;
                }
            }
            FileInputStream inputStream = new FileInputStream(path);

            ps.setObject(1, "25");
            ps.setObject(2, name);
            ps.setObject(3, "女");
            ps.setBlob(4, inputStream);
            ps.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.closeResource(connection, ps);
        }
    }

    @Test
    public void test() {
        File file = new File("C:\\Users\\Administrator\\Pictures\\壁纸");
        File[] files = file.listFiles();
        for (File file1 : files) {

            while (file1.getName().contains("薇恩.jpg")) {
                System.out.println(file1.getName());
                break;
            }
        }
    }

    @Test
//    读取mysql中包含图片的数据
    public void ReadTest() {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "select * from test where name = '卡莎'";
            ps = connection.prepareStatement(sql);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String sex = resultSet.getString("sex");
                Blob picture = resultSet.getBlob("picture");
                testClass testClass = new testClass(id, name, sex, picture);
                System.out.println(testClass);
                InputStream is = picture.getBinaryStream();
                FileOutputStream fos = new FileOutputStream("卡莎.jpg");
                byte[] bytes = new byte[1024];
                int len;
                while ((len = is.read(bytes)) != -1) {
                    fos.write(bytes, 0, len);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.closeResourceQuery(connection, ps, resultSet);
        }
    }
}

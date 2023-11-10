package javase.Collection;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author pzy
 * @create 2023-09-15-20:50
 * @function
 */
public class PropertiesTest {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            Properties properties = new Properties();

            fis = new FileInputStream("Test.properties");
            properties.load(fis);

            String name = properties.getProperty("name");
            String password = properties.getProperty("password");

            System.out.println("name =" + name + ",password =" + password);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}

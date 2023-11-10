package javase.IO;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author pzy
 * @create 2023-09-20-22:41
 * @function 1.转换流
 * InputStreamReader：将字节的输入流转换为字符的输入流
 * OutputStreamWriter：将字符的输出流转换为字节的输出流
 * 2.提供字节流和字符流之间的转换
 * 3.解码：字节，字符数组-->字符串，字符数组
 * 编码：字符串，字符数组-->字节，字节数组
 * 4.字符集(编码集，解码集)
 */
public class InputStreamReaderTest {
    @Test
    public void test() throws IOException {
//      当未指定绝对路径时默认去当前模块下查找该文件
        FileInputStream inputStream = new FileInputStream("LICENSE.txt");
//      不指定使用IDEA默认的字符集
        InputStreamReader streamReader = new InputStreamReader(inputStream, "UTF-8");
//        也可以在使用OutputStreamWriter时使用不同的字符集
        char[] a = new char[1024];
        int len;
        while ((len = streamReader.read(a)) != -1) {
            String s = new String(a,0,len);
            System.out.println(s);
        }
        streamReader.close();
    }
}

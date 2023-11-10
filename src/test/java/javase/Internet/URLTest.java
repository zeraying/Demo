package javase.Internet;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author pzy
 * @create 2023-09-24-21:32
 * @function 了解URL中的各种方法
 */
public class URLTest {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.bilibili.com/video/BV1Bh411h7Zo/?p=625&spm_id_from=pageDriver&vd_source=e80b1ddaf0ffb0e452cdb47665f797ee");
//            获取该url的协议名
            System.out.println(url.getProtocol());
//            获取该url的主机名
            System.out.println(url.getHost());
//            获取该url的端口号
            System.out.println(url.getPort());
//            获取该url的文件路径
            System.out.println(url.getPath());
//            获取该url的文件名
            System.out.println(url.getFile());
//            获取该url的查询名
            System.out.println(url.getQuery());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }
}

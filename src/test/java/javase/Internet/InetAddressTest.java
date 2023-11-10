package javase.Internet;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author pzy
 * @create 2023-09-23-19:32
 * @function
 * 1.本地回路地址：127.0.0.1  对应着localhost
 */
public class InetAddressTest {
    public static void main(String[] args) {
        try {
            InetAddress name = InetAddress.getByName("192.168.10.11");
            System.out.println(name);
//            域名解析
            InetAddress name1 = InetAddress.getByName("www.baidu.com");
            System.out.println(name1);
//            getHostName
            System.out.println(name1.getHostName());
//            getHostAddress
            System.out.println(name1.getHostAddress());
            InetAddress name2 = InetAddress.getByName("localhost");
            System.out.println(name2);
//            直接获取本机地址
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println(localHost);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
}

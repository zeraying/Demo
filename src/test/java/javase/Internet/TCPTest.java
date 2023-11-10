package javase.Internet;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author pzy
 * @create 2023-09-23-20:12
 * @function 实现TCP的网络编程
 * 例一：客户端发送数据到服务端，服务端接收数据输出到控制台
 */
public class TCPTest {
    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;
        try {
//            1.创建Socket对象，指明服务器端的ip和端口号
            InetAddress name = InetAddress.getByName("127.0.0.1");
            socket = new Socket(name, 8899);
//            2.获取一个输出流，用于输出数据
            os = socket.getOutputStream();
//            3.写出数据
            os.write("你好，这里是客户端".getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
//            4.资源的关闭
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Test
    public void server() {
        ServerSocket serverSocket = null;
        Socket accept = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
//            1.创建服务器端的ServerSocket，指明自己的端口号
            serverSocket = new ServerSocket(8899);
//            2.调用accept()表示接收来自于客户端的Socket
            accept = serverSocket.accept();
//            3.获取输入流
            is = accept.getInputStream();
//            不建议这样写，可能出现乱码，汉字被从中间截取
//            byte[] bytes = new byte[5];
//            int len;
//            while ((len = is.read(bytes)) != -1) {
//                String s = new String(bytes, 0, len);
//                System.out.println(s);
//            }
//            4.读取输入流中的数据
            baos = new ByteArrayOutputStream();
            byte[] bytes = new byte[5];
            int len;
            while ((len = is.read(bytes)) != -1) {
                baos.write(bytes, 0, len);
            }
            System.out.println(baos.toString());
            System.out.println(serverSocket.getInetAddress().getHostAddress());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
//            5.资源的关闭
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (accept != null) {
                try {
                    accept.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

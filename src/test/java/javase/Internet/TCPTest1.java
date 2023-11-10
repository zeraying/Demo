package javase.Internet;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author pzy
 * @create 2023-09-23-22:14
 * @function 实现TCP的网络编程
 * 例二：客户端发送文件到服务端，服务端接收文件保存到本地
 */
public class TCPTest1 {
    @Test
    public void client() {
        FileInputStream inputStream = null;
        Socket socket = null;
        OutputStream os = null;
        try {
            inputStream = new FileInputStream(new File("D:\\study\\IDEA\\IDEAproject\\Demo\\src\\test\\java\\javase\\IO\\picture.jpg"));
            InetAddress name = InetAddress.getByName("127.0.0.1");
            socket = new Socket(name, 8899);
            os = socket.getOutputStream();
            byte[] bytes = new byte[1024];
            int len;
            while ((len = inputStream.read(bytes)) != -1) {
                os.write(bytes, 0, len);
            }
            socket.shutdownOutput();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Test
    public void server() {
        ServerSocket ss = null;
        Socket accept = null;
        InputStream is = null;
        FileOutputStream os = null;
        try {
            ss = new ServerSocket(8899);
            accept = ss.accept();
            is = accept.getInputStream();
            os = new FileOutputStream(new File("D:\\study\\IDEA\\IDEAproject\\Demo\\src\\test\\java\\javase\\Internet\\picture.jpg"));
            byte[] bytes = new byte[1024];
            int len;
            while ((len = is.read(bytes)) != -1) {
                os.write(bytes, 0, len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (os != null) {
                try {
                    os.close();
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
            if (ss != null) {
                try {
                    ss.close();
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
        }
    }
}

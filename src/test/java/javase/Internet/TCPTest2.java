package javase.Internet;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author pzy
 * @create 2023-09-23-23:37
 * @function 实现TCP的网络编程
 * 例三：客户端发送文件到服务端，服务端接收文件保存到本地并返回接收成功到客户端，并在控制台显示
 */
public class TCPTest2 {
    @Test
    public void client() {
        FileInputStream inputStream = null;
        Socket socket = null;
        OutputStream os = null;
        InputStream input = null;
        ByteArrayOutputStream stream = null;
        try {
            inputStream = new FileInputStream(new File("D:\\study\\IDEA\\IDEAproject\\Demo\\src\\test\\java\\javase\\Internet\\picture.jpg"));
            InetAddress name = InetAddress.getByName("127.0.0.1");
            socket = new Socket(name, 8899);
            os = socket.getOutputStream();
            byte[] bytes = new byte[1024];
            int len;
            while ((len = inputStream.read(bytes)) != -1) {
                os.write(bytes, 0, len);
            }
//            在这里需要对套接字进行关闭，不然会一直开着等着读取图片，关闭的是套接字的传输通道
            socket.shutdownOutput();
//            接收服务端返回的消息
            input = socket.getInputStream();
            stream = new ByteArrayOutputStream();
            byte[] bytes1 = new byte[1024];
            int len1;
            while ((len1 = input.read(bytes1)) != -1) {
                stream.write(bytes1,0,len1);
            }
            System.out.println(stream);
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
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (input != null) {
                try {
                    input.close();
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
        OutputStream output = null;
        try {
            ss = new ServerSocket(8899);
            accept = ss.accept();
            is = accept.getInputStream();
            os = new FileOutputStream(new File("D:\\study\\IDEA\\IDEAproject\\Demo\\src\\test\\java\\javase\\Internet\\picture1.jpg"));
            byte[] bytes = new byte[1024];
            int len;
            while ((len = is.read(bytes)) != -1) {
                os.write(bytes, 0, len);
            }
//            返回一个接收成功的消息给客户端
            output = accept.getOutputStream();
            output.write("接收成功".getBytes());
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
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

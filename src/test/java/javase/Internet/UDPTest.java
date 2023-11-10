package javase.Internet;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * @author pzy
 * @create 2023-09-24-20:06
 * @function 实现UDP的网络编程，发送端发出数据服务端接收数据直到接收到数据为"e"
 */
public class UDPTest {
    public static void main(String[] args) throws IOException {
        UDPTest udpTest = new UDPTest();
        udpTest.sender();
    }
    //    发送端
//    @Test在测试类中不能使用输入语句
    public void sender() throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket();
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String str = scanner.next();
            byte[] bytes = str.getBytes();
            InetAddress name = InetAddress.getByName("127.0.0.1");
            DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, bytes.length, name, 8080);
            datagramSocket.send(datagramPacket);
            if (str.equals("e")) {
                break;
            }
        }
        datagramSocket.close();
    }

    //    接收端
    @Test
    public void receiver() throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(8080);
        while (true) {
        byte[] bytes = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, bytes.length);
        datagramSocket.receive(datagramPacket);
        byte[] data = datagramPacket.getData();
        String ReceiverData = new String(bytes, 0, bytes.length).trim();
        System.out.println(ReceiverData);
            if (ReceiverData.equals("e")){
                break;
            }
        }
        datagramSocket.close();

    }
}

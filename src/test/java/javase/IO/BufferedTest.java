package javase.IO;

import org.junit.Test;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author pzy
 * @create 2023-09-20-11:20
 * @function 缓冲流的使用
 * 1.BufferedInputStream
 * 2.BufferedOutputStream
 * 3.BufferedReader
 * 4.BufferedWriter
 * 作用：提高流的读取，写入的速度，因为内部提供了一个缓冲区
 * 处理流；就是“套接”在已有的流的基础上的流。
 *
 */
public class BufferedTest {
    public static void main(String[] args) {

    }

    /**
     * 1.对文本文件，使用字符流处理
     * 2.对于非文本文件如图片，使用字节流处理
     */
    @Test
    public void test() {
        BufferedInputStream bufferedInput = null;
        BufferedOutputStream bufferedOutput = null;
        try {
            File file = new File("D:\\study\\IDEA\\IDEAproject\\Demo\\src\\test\\java\\javase\\IO\\picture.jpg");
            File file1 = new File("D:\\study\\IDEA\\IDEAproject\\Demo\\src\\test\\java\\javase\\IO\\picture2.jpg");
//            节点流
            FileInputStream inputStream = new FileInputStream(file);
            FileOutputStream outputStream = new FileOutputStream(file1,false);
//            缓冲流
            bufferedInput = new BufferedInputStream(inputStream);
            bufferedOutput = new BufferedOutputStream(outputStream);
            byte[] a = new byte[1024];
            int len;
            while ((len = bufferedInput.read(a)) != -1) {
                bufferedOutput.write(a, 0, len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
//                关闭外层流的同时，内层流也会自动的进行关闭
                bufferedInput.close();
                bufferedOutput.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    @Test
    public void test2()  {
        FileReader reader = null;
        FileWriter writer = null;
        try {
            reader = new FileReader(new File("D:\\study\\IDEA\\IDEAproject\\Demo\\src\\test\\java\\javase\\IO\\LICENSE.txt"));
            writer = new FileWriter(new File("D:\\study\\IDEA\\IDEAproject\\Demo\\src\\test\\java\\javase\\IO\\LICENSE1.txt"),false);
            char[] a = new char[1];
            Map<String, Integer> hashMap = new HashMap<>();
            while (reader.read(a) != -1){
                String c= Arrays.toString(a);
                if (hashMap.containsKey(c)){
                    System.out.println(hashMap.get(c));
                    hashMap.put(Arrays.toString(a),hashMap.get(c)+1);
                }else {
                    hashMap.put(c,1);
                }
            }
            Set<Map.Entry<String, Integer>> entries1 = hashMap.entrySet();
            for (Map.Entry<String, Integer> entry: entries1){
//                System.out.println(entry.getKey() + "+" + entry.getValue());
                switch (entry.getKey()){
                    case " ":
                        writer.write("空格="+entry.getKey()+'\n');
                        break;
                    case "\t":
                        writer.write("tab键="+entry.getKey()+'\n');
                        break;
                    case "\r":
                        writer.write("回车="+entry.getKey()+'\n');
                        break;
                    case "\n":
                        writer.write("换行="+entry.getKey()+'\n');
                        break;
                    default:
                        writer.write(entry.getKey()+"="+entry.getValue()+'\n');
                        break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                reader.close();
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}

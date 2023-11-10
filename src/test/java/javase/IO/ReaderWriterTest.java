package javase.IO;

import org.junit.Test;

import java.io.*;

/**
 * @author pzy
 * @create 2023-09-19-10:53
 * @function
 */
public class ReaderWriterTest {
    public static void main(String[] args) {
//        相较于当前工程
        File file = new File("hi.txt");
        System.out.println(file.getAbsolutePath());
        File file1 = new File("javase\\hi.txt");
        System.out.println(file1.getAbsolutePath());
    }

    @Test
    public void FileReader() {
        FileReader reader = null;
        try {
//        1.实例化File类的对象，指明要操作的文件
            File file = new File("D:\\study\\IDEA\\IDEAproject\\Demo\\src\\test\\java\\javase\\IO\\hi.txt");
//      System.out.println(file.getAbsolutePath());
//        2.提供具体的流
            reader = new FileReader(file);
//        3.数据的读入
            int data;
            while ((data = reader.read()) != -1) {
                System.out.println((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
//        4.流的关闭操作
            try {
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Test
    public void FileWriter(){
//        1.提供File类的对象，指明写出到的文件
        File file = new File("D:\\study\\IDEA\\IDEAproject\\Demo\\src\\test\\java\\javase\\IO\\hi1.txt");
        FileWriter fileWriter = null;
        try {
//        2.提供FileWriter的对象，用于数据的写出
//            当参数为True时，对文件进行追加写，False为覆盖写
            fileWriter = new FileWriter(file,true);
//        3.写出的操作
            fileWriter.write("hello world"+"\n");
            fileWriter.write("你好，世界！"+"\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
//        4.流资源的关闭
            try {
                fileWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    /**
     * 从内存中写出数据到硬盘的文件里
     * 输出操作：当文件不存在时，会自动创建文件
     *          若存在，当流使用的构造器是：FileWriter(file,false),对文件覆盖写
     *                                 ：FileWriter(file,true),对文件追加写
     */
    @Test
    public void ReaderAndWriter(){
//        1.提供file类的对象，指明读入和写出的文件
        File hi1 = new File("D:\\study\\IDEA\\IDEAproject\\Demo\\src\\test\\java\\javase\\IO\\hi1.txt");
        File hi2 = new File("D:\\study\\IDEA\\IDEAproject\\Demo\\src\\test\\java\\javase\\IO\\hi2.txt");
//        2.提供数据读入和写出的对象
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            fileReader = new FileReader(hi1);
            fileWriter = new FileWriter(hi2,false);
//        3.数据读入和写出的操作
            /**
             * 一次读取5个字节
             * chat[] cbuf = new char[5];
             * int len = reader.read(cbuf);
             */
            char[] a = new char[5];
            int len;
            while ((len=fileReader.read(a)) != -1){
                fileWriter.write(a,0,len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
//        4.关闭读入和写出流
            try {
                fileReader.close();
                fileWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    @Test
    public void ReaderAndWriterPicturer(){
//        1.提供file类的对象，指明读入和写出的文件
        File hi1 = new File("D:\\study\\IDEA\\IDEAproject\\Demo\\src\\test\\java\\javase\\IO\\picture.jpg");
        File hi2 = new File("D:\\study\\IDEA\\IDEAproject\\Demo\\src\\test\\java\\javase\\IO\\picture1.jpg");
//        2.提供数据读入和写出的对象
        FileInputStream fileReader = null;
        FileOutputStream fileWriter = null;
        try {
            fileReader = new FileInputStream(hi1);
            fileWriter = new FileOutputStream(hi2,false);
//        3.数据读入和写出的操作
            byte[] a = new byte[100];
            int len;
            while ((len=fileReader.read(a)) != -1){
                fileWriter.write(a,0,len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
//        4.关闭读入和写出流
            try {
                fileReader.close();
                fileWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
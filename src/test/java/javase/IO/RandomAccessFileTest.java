package javase.IO;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author pzy
 * @create 2023-09-22-22:15
 * @function RandomAccessFile的使用
 * 1.RandomAccessFile直接继承于java.lang.Object类，实现了DataInput和DataOutput接口
 * 2.RandomAccessFile既可以作为一个输入流，又可以作为一个输出流
 * 3.RandomAccessFile作为输出流时，文件不存在自动创建，若存在，则对文件里的内容从头开始覆盖
 * 4.可以通过将要插入位置后的数据放入另一个文件再插入实现数据的插入操作
 */
public class RandomAccessFileTest {
    @Test
    public void test1() {
        RandomAccessFile accessFile = null;
        RandomAccessFile accessFile1 = null;
        try {
            accessFile = new RandomAccessFile(new File("D:\\study\\IDEA\\IDEAproject\\Demo\\src\\test\\java\\javase\\IO\\picture.jpg"), "rw");
            accessFile1 = new RandomAccessFile(new File("D:\\study\\IDEA\\IDEAproject\\Demo\\src\\test\\java\\javase\\IO\\picture3.jpg"), "rw");
            byte[] bytes = new byte[1024];
            int len;
            while ((len = accessFile.read(bytes)) != -1) {
                accessFile1.write(bytes,0,len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (accessFile != null) {
                try {
                    accessFile.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (accessFile1 != null) {
                try {
                    accessFile1.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    @Test
    public void test2() throws IOException {
        RandomAccessFile accessFile = new RandomAccessFile(new File("D:\\study\\IDEA\\IDEAproject\\Demo\\src\\test\\java\\javase\\IO\\hi2.txt"), "rw");
        accessFile.seek(3);//将指针调整到角标为3的位置

    }
}

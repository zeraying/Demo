package javase.IO;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @author pzy
 * @create 2023-09-18-19:38
 * @function File文件的相关操作
 */
public class FileTest {
    public static void main(String[] args) {
        File file = new File("hello.txt");
        System.out.println(file);
        File file1 = new File("D:\\study\\IDEA\\IDEAproject" +
                "\\Demo\\src\\test\\java\\javase\\IO\\hi.txt");
        System.out.println(file1);
    }
    @Test
    public void test1(){
        File file = new File("hello.txt");
        File file1 = new File("D:\\study\\IDEA\\IDEAproject" +
                "\\Demo\\src\\test\\java\\javase\\IO\\hi.txt");
//        获取绝对路径
        System.out.println(file.getAbsoluteFile());
//        获取路径
        System.out.println(file.getPath());
//        获取名称
        System.out.println(file.getName());
//        获取上层文件目录路径，若无，返回null
        System.out.println(file.getParent());
//        获取文件长度
        System.out.println(file.length());
//        获取文件最后一次的修改时间
        System.out.println(new Date(file.lastModified()));

        System.out.println("--------------");

        System.out.println(file1.getAbsoluteFile());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(new Date(file1.lastModified()));
    }
    @Test
    public void test2(){
        File file = new File("D:\\study\\IDEA\\IDEAproject" +
                "\\Demo\\src\\test\\java\\javase");
//        获取指定目录下的所有文件或者文件目录的名称数组
        String[] list = file.list();
        for (String s : list){
            System.out.println(s);
        }
        System.out.println("------------");
//        获取指定目录下的所有文件或者文件目录的File数组
        File[] files = file.listFiles();
        for (File i : files){
            System.out.println(i);
        }
    }
    /**
     *public boolean renameTo(File dest):将文件重命名为指定的文件路径
     * file1在硬盘中存在，file2在硬盘中不存在
     */
    @Test
    public void test3(){
        File file = new File("D:\\study\\IDEA\\IDEAproject" +
                "\\Demo\\src\\test\\java\\javase\\IO\\hi.txt");
        File file1 = new File("D:\\study\\IDEA\\IDEAproject" +
                "\\Demo\\src\\test\\java\\javase\\IO");
//        判断是否是文件
        System.out.println(file.isFile());
//        判断是否是文件目录
        System.out.println(file1.isDirectory());
//        判断文件是否存在
        System.out.println(file1.exists());
//        判断文件是否可读
        System.out.println(file.canRead());
//        判断文件是否可写
        System.out.println(file.canWrite());
//        判断文件是否隐藏
        System.out.println(file.isHidden());
    }
    @Test
    public void tet4(){
        File file = new File("D:\\study\\IDEA\\IDEAproject" +
                "\\Demo\\src\\test\\java\\javase\\IO");
        try {
//            创建文件，文件存在则不创建
            System.out.println(file.createNewFile());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        创建文件目录，文件的上层目录不存在就不创建
        System.out.println(file.mkdir());
//        创建文件目录，文件的上层目录不存在一并创建
        System.out.println(file.mkdirs());


    }
}
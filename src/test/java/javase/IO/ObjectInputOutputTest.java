package javase.IO;

import org.junit.Test;

import java.io.*;

/**
 * @author pzy
 * @create 2023-09-22-20:17
 * @function 对象流的使用(序列化与反序列化)
 * 1.ObjectInputStream和ObjectOutputStream(字节流)
 * 2.用于存储和读取基本数据类型数据或对象的处理流
 * 3.Person需要满足如下条件方可序列化
 *    1.实现Serializable接口
 *    2.声明序列版本号static final long serialVersionUID = 42134134L;要与原来的不同
 *    3.还需要保证其内部的所有属性也必须是可序列化的(默认情况下，基本数据类型是可序列化的)
 *    4.static和transient修饰的成员变量不能序列化
 */
public class ObjectInputOutputTest {
    /**
     * 序列化：将内存中的java对象保存到磁盘中或通过网络传输出去
     * 使用ObjectOutputStream实现
     */
    @Test
    public void test1() {
        ObjectOutputStream outputStream = null;
        String s = new String("我爱北京天安门");
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream("D:\\study\\IDEA\\IDEAproject\\Demo\\src\\test\\java\\javase\\IO\\Object.data"));
            outputStream.writeObject(s);
            outputStream.flush();//刷新操作
            outputStream.writeObject(new person("小明",20));
            outputStream.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
    /**
     * 反序列化：将磁盘或网络中的java对象加载到内存中
     * 使用ObjectInputStream实现
     */
    @Test
    public void test2(){
        ObjectInputStream inputStream = null;
        try {
            inputStream = new ObjectInputStream(new FileInputStream("D:\\study\\IDEA\\IDEAproject\\Demo\\src\\test\\java\\javase\\IO\\Object.data"));
            Object o = inputStream.readObject();
//            String o1 = (String) o;
            System.out.println(o);
            person p = (person) inputStream.readObject();
            System.out.println(p);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

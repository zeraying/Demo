package javase.IO;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author pzy
 * @create 2023-09-21-11:05
 * @function 将输入的字符自动转换为大写输出,然后继续进行操作
 *            直到输入“e”或 “exit”，退出程序。
 */
public class OtherStreamTest {
    public static void main(String[] args) {
        OtherStreamTest test = new OtherStreamTest();
        test.test();
    }
    /**
     * 1.标准的输入，输出流
     * 1.1
     * System.in:标准的输入流，默认从键盘输入
     * System.out:标准的输出流，默认从控制台输出
     * 在测试集中无法使用标准的输入输出流需要在主函数中调用
     * 1.2
     * System类的setIn(InputStream is)/setOut(PrintStream ps)重新指定输入和输出的流
     */
    @Test
    public void test() {
        BufferedReader reader = null;
        try {
            InputStreamReader streamReader = new InputStreamReader(System.in);
            reader = new BufferedReader(streamReader);
            while (true) {
                System.out.println("请输入字符串");
                String data = reader.readLine();
                if ("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)) {
                    System.out.println("程序结束");
                    break;
                }
                String s = data.toUpperCase();
                System.out.println(s);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}

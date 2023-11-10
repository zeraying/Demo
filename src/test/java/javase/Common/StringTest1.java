package javase.Common;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * @author pzy
 * @create 2023-09-07-10:17
 * @function String类的数据类型转换
 */
public class StringTest1 {
//    String类与基本数据类型，包装类之间的转换
    @Test
    public void test1(){
        String s = "123";
        int i = Integer.parseInt(s);
        System.out.println(i);
        System.out.println(String.valueOf(i));
    }
    @Test
    public void test2(){
        String s = "abc123";
        System.out.println(s.toCharArray());
//      转为char型数组
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }
        String s1 = new String(chars);//相当于解码
        System.out.println(s1);
//      转为byte型数组
//        for (byte aByte : s.getBytes()) {
//            System.out.println(aByte);
//        }
//        byte[] bytes = s.getBytes();//使用默认的字符集编码

        byte[] gbks = new byte[0];
        try {
            gbks = s.getBytes("gbk");//使用指定字符集编码
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < gbks.length; i++) {
                System.out.println(gbks[i]);
            }

    }
}

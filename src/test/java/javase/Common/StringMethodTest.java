package javase.Common;

import org.junit.Test;

 /**
 * @author pzy
 * @create 2023-09-06-22:22
 * @function String中常用的方法
 */
public class StringMethodTest {
    @Test
    public void test1() {
        String s = "hello world";
//        返回字符串的长度
        System.out.println(s.length());
//        返回指定索引处的字符
        System.out.println(s.charAt(1));
//        判断是否是空字符串
        System.out.println(s.isEmpty());
//        将所有字符转为小写
        System.out.println(s.toLowerCase());
//        将所有字符转为大写
        System.out.println(s.toUpperCase());
    }
    @Test
    public void test2(){
        String s = "hello world";
        String s1 = "    hello wor l d    ";
//        忽略字符串前后的空格
        System.out.println(s1.trim());
//        比较字符串内容是否相同
        System.out.println(s.equals(s1));
        String s2 = "Hello World";
//        与equals类似忽略大小写
        System.out.println(s.equalsIgnoreCase(s2));
//        将指定字符串连接到末尾，与“+”类似
        System.out.println(s.concat(s2));
//        与其他的字符串比较大小
        String s3 = "abc";
        String s4 = new String("abe");
        System.out.println(s3.compareTo(s4));//涉及到字符串排序
    }
    @Test
    public void test3(){
        java.lang.String s5 = "涉及到字符串排序";
        System.out.println(s5);
//        返回从指定位置截取的文件
        System.out.println(s5.substring(3));
        System.out.println(s5.substring(3, 6));
//        判断是否是以指定字符串结束
        System.out.println(s5.endsWith("序"));
//        判断是否是以指定字符串开始
        System.out.println(s5.startsWith("涉"));
        System.out.println(s5.startsWith("到", 2));
    }
    @Test
    public void test4(){
        String s ="dsdadadasdad";
//        判断字符串中是否包含指定的字符串
        System.out.println(s.contains("da"));
//        返回指定字符串第一次出现的索引
        System.out.println(s.indexOf("da"));
//        返回指定字符串在指定位置处第一次出现的索引
        System.out.println(s.indexOf("ad", 4));
        System.out.println(s.lastIndexOf("da"));
        System.out.println(s.lastIndexOf("da", 3));

    }
    @Test
    public void test5(){
        String s = "1abc31de12f53ab5c1";
        System.out.println(s.replace("a", "g"));
//        将所有数字替换为逗号，这里匹配的是正则表达式
        System.out.println(s.replaceAll("\\d+", ",")
//        若开头或结尾有逗号将其去掉,如果没有$的话就是将所有的逗号都去掉
                .replaceAll("^,|,$",""));
        String s1 = "0731-113456098";
//        判断是否全是数字
        System.out.println(s1.matches("\\d+"));
//        判断是否是固定格式
        System.out.println(s1.matches("0731-\\d{5,13}"));
        String[] strs =s1.split("\\-");
        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }
    }
}

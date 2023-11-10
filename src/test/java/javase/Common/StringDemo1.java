package javase.Common;

import org.junit.Test;

/**
 * @author pzy
 * @create 2023-09-08-14:28
 * @function 获取一个字符串在另一个字符串中出现的次数
 */
public class StringDemo1 {
    public int countStr(String mainStr, String subStr) {
        int length = mainStr.length();
        int length1 = subStr.length();
        int count = 0;
        int index = 0;
        if (length >= length1) {
//            方式一:
//            while ((index = mainStr.indexOf(subStr)) != -1) {
//                count++;
//                mainStr = mainStr.substring(index + subStr.length());
//            }
//            方式二:
            while ((index = mainStr.indexOf(subStr,index)) != -1) {
                count++;
                index = index+subStr.length();
            }
            return count;
        } else {
            return 0;
        }
    }

    @Test
    //带@Test的方法不能去调另一个带@Test的方法
    public void test() {
        String mainStr = "adhhjhjadfttaaadtytyda";
        String subStr = "ad";
        int a = countStr(mainStr, subStr);
        System.out.println(a);
    }

}

package javase.Common;

/**
 * @author pzy
 * @create 2023-09-07-23:04
 * @function 对指定的字符串的一部分进行反转 abcdefg
 */
public class StringDemo {
    public static void main(String[] args) {
        StringDemo stringDemo = new StringDemo();
        System.out.println(stringDemo.fanzhuan2("abcdefg", 2, 5));
    }


    //    方式一：将字符串转为char型数组进行反转
    public String fanzhuan(String str, int startindex, int endindex) {
        if (str != null) {
            char[] chars = str.toCharArray();
            for (int i = startindex, j = endindex; i < j; i++, j--) {
                char a = chars[i];
                chars[i] = chars[j];
                chars[j] = a;
            }
            return new String(chars);
        }
        return null;
    }

    //    方式二：截取，反转，拼接
    public String fanzhuan1(String str, int startindex, int endindex) {
        if (str != null) {
            String str1 = str.substring(0, startindex);
            for (int i = endindex; i >= startindex; i--) {
                str1 += str.charAt(i);
            }
            str1 += str.substring(endindex + 1);
            return str1;
        }
        return null;
    }
    //       方式三：将String字符串转为StringBuffer/StringBuilder
    public String fanzhuan2(String str, int startindex, int endindex) {
        StringBuffer stringBuffer = new StringBuffer(str);
        StringBuffer stringBuffer1 = new StringBuffer();
        stringBuffer1.append(stringBuffer.substring(0,startindex));
        for (int i = startindex,j = endindex; i <= j; j--) {
            stringBuffer1.append(stringBuffer.charAt(j));
        }
        stringBuffer1.append(stringBuffer.substring(endindex+1));
        return new String(stringBuffer1);
    }
}


package javase.Common;

import org.junit.Test;

/**
 * @author pzy
 * @create 2023-09-08-15:19
 * @function 获取两个字符串中最大相同子串
 */
public class StringDemo2 {
    public static void main(String[] args) {
        StringDemo2 stringDemo2 = new StringDemo2();
        System.out.println(stringDemo2.getmaxStr("asdfgsdfgasdf", "ladfgsl"));
    }
    public String getmaxStr(String str1, String str2) {

//        int length = str2.length();
//        for (int i = 0; i < length; i++) {
//            int after = length-1-i;
//            int pre = 0;
//            while(after<length){
//                String s = str2.substring(pre, after);
//                if (str1.contains(s)){
//                    return s;
//                }else{
//                    pre++;
//                    after++;
//                }
//            }
//        }
//        return "";
        String maxStr = "";
//        if (str1.length() >= str2.length()) {
            maxStr = str2;
//            while (str1.contains(maxStr) == false) {
                for (int j = 0 ,i =0; j < str2.length(); i++,j++) {
                    maxStr = str2.substring(i, str2.length() - j);
                        if (str1.contains(maxStr) != false){
                            return maxStr;
                        }
//                }
//            }
        }
        return maxStr;
    }
@Test
    public void a(){
    System.out.println(getmaxStr("asdfgsdfgasdf", "ldfgsl"));
}
}

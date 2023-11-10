package javase.Common;

/**
 * @author pzy
 * @create 2023-09-07-11:20
 * @function 关于StringBuffer和StringBuilder的使用
 */
public class StringBufferBuilder {
    /**
     * String,StringBuffer,StringBuilder之间的区别
     * String：不可变字符序列
     * <p>
     * StringBuffer:可变字符序列，线程安全，效率低
     * 常用方法：
     * append()进行字符串拼接
     * delete(int strat, int end)删除指定位置的内容
     * replace(int strat, int end, String str)将指定位置替换为str
     * insert(int offset,xxx)在指定位置插入xxx
     * reverse()把当前字符序列逆转
     * int indexOf(String str)
     * String substring(int start, int end)截取字符串
     * int length()
     * char charAt(int n)
     * setCharAt(int n, char ch)
     * <p>
     * StringBuilder:可变字符序列，线程不安全，效率高
     */
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("abcd");
        System.out.println(sb.delete(1, 3));
        System.out.println(sb.insert(2, "gg"));
    }
}

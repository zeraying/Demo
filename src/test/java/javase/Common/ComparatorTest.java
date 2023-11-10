package javase.Common;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author pzy
 * @create 2023-09-09-17:22
 * @function 当前元素类型没有实现Comparable接口，不方便次修改代码，或排序规则不符合当前操作
 */
public class ComparatorTest {
    public static void main(String[] args) {
        ComparatorTest comparatorTest = new ComparatorTest();
        comparatorTest.test();
    }
    @Test
    public void test() {
        String[] str = new String[]{"BB", "MM", "XX", "CC", "AA"};
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1 instanceof String && o2 instanceof String) {
                    String s1 = (String) o1;
                    String s2 = (String) o2;
//                    倒序
                    return -s1.compareTo(s2);
                }
                throw new RuntimeException("数据类型不一致");
            }
        });
        System.out.println(Arrays.toString(str));
    }

    @Test
    public void goodstest() {
        goods[] arr = new goods[10];
        arr[0] = new goods("华为", 1111, 2454);
        arr[1] = new goods("vivo", 9699, 1643);
        arr[2] = new goods("小米", 1111, 1654);
        arr[3] = new goods("mate60", 2111, 1133);
        arr[4] = new goods("oppo", 6676, 36456);
        arr[5] = new goods("联想", 6676, 3446);
        arr[6] = new goods("小米", 666, 2453);
        arr[7] = new goods("诺基亚", 666, 6523);
        arr[8] = new goods("魅族", 7633, 7513);
        arr[9] = new goods("苹果", 2344, 1133);

        Arrays.sort(arr, new Comparator<goods>() {
            @Override
            public int compare(goods o1, goods o2) {
                if (o1 instanceof goods && o2 instanceof goods) {
                    goods g1 = (goods) o1;
                    goods g2 = (goods) o2;
                    if (g1.getName().equals(g2.getName())) {
                        return Double.compare(g1.getPrice(),g2.getPrice());
                    }else return g1.getName().compareTo(g2.getName());
                }
                return 0;
            }
        });
        System.out.println(Arrays.toString(arr));

    }
}

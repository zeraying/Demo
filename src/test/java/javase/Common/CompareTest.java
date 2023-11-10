package javase.Common;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author pzy
 * @create 2023-09-09-15:55
 * @function 1.对对象进行排序，需要使用Comparable(自然排序)或Comparator(定制排序)接口
 *           2.Comparable重写CompareTo方法，Comparator重写Compare方法。
 */
public class CompareTest {
    @Test
    public void strTest() {
        String[] str = new String[]{"BB", "MM", "XX", "CC", "AA"};
        Arrays.sort(str);
        System.out.println(Arrays.toString(str).toString());
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
        arr[6] = new goods("红米", 666, 2453);
        arr[7] = new goods("诺基亚", 666, 6523);
        arr[8] = new goods("魅族", 7633, 7513);
        arr[9] = new goods("苹果", 2344, 1133);

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

    }

}

class goods implements Comparable {
    private String name;
    private double price;
    private int idx;

    public goods() {
    }

    public goods(String name, double price, int idx) {
        this.name = name;
        this.price = price;
        this.idx = idx;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof goods) {
            goods o1 = (goods) o;
//            if (this.price > o1.price) {
//                return 1;
//            } else if (this.price < o1.price) {
//                return -1;
//            } else if (this.idx > o1.idx) {
//                return 1;
//            } else if (this.idx < o1.idx) {
//                return -1;
//            }
            if (this.price != o1.getPrice()) {
                return Double.compare(this.getPrice(), o1.getPrice());
            } else if (this.idx != o1.idx) {
                return Double.compare(this.idx, o1.idx);
            }
            return 0;
        }
        throw new RuntimeException("传入的数据类型不一致");
    }

    @Override
    public String toString() {
        return "goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", idx=" + idx +
                '}' + '\n';
    }
}
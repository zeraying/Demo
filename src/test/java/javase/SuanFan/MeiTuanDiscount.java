package javase.SuanFan;

import java.util.*;

/**
 * @author pzy
 * @create 2023-09-11-15:32
 * @function
 */
// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class MeiTuanDiscount {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入菜的总数");
        int n = in.nextInt();
        double a[] = new double[2];
        int c = 0;
        double yuan = 0, dis = 0, mj = 0, x = 0, y = 0,z=0;
        // 注意 hasNext 和 hasNextLine 的区别
        while (c < n) {
            // 注意 while 处理多个 case
            for (int j = 0; j < 2; j++) {
                a[j] = in.nextDouble();
                if (a[j]<0) {
                    z=-1;
                }
            }
//            System.out.println(a + b);
            c++;
            yuan += a[0];
            dis += a[1];
        }
        System.out.println(yuan);
        System.out.println(dis);
        System.out.println("请输入满减规则");
        x = in.nextInt();
        y = in.nextInt();
        if (yuan > x) {
            mj = yuan - y;
        }
        Collection coll = new ArrayList<>();
        double i[] = new double[]{n, c, x, y};
        Double[] it = Arrays.stream(i).boxed().toArray(Double[]::new);
        List<Double> integers = Arrays.asList(it);
        integers.add(0,z);
        if (0 <= integers.get(0) && integers.get(integers.size() - 1) <= 100000) {
            if (yuan < x) {
                System.out.printf("%.2f%n", dis);
            } else if (mj > dis) {
                System.out.printf("%.2f%n", dis);
            } else {
                System.out.printf("%.2f%n", mj);
            }
        } else {
            System.out.println("error");
        }
    }
}

/**
 * Scanner in = new Scanner(System.in);
 * // 注意 hasNext 和 hasNextLine 的区别
 * while (in.hasNextInt()) { // 注意 while 处理多个 case
 * int a = in.nextInt();
 * int b = in.nextInt();
 * System.out.println(a + b);
 * }
 * }
 */

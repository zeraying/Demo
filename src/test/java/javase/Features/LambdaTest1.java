package javase.Features;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author pzy
 * @create 2023-09-28-16:25
 * @function java内置的4大核心函数式接口
 * 消费型接口 Consumer<T>  void accept(T t)
 * 供给型接口 Supplier<T>  T get()
 * 函数型接口 Function<T,R>  R apply(T t)
 * 断定型接口 Predicate<T>  boolan test(T t)
 */
public class LambdaTest1 {
    @Test
    public void test() {
        happy(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("上" + aDouble + "个小时的网放松一下");
            }
        });
        System.out.println("**********************");
        happy(500, money -> System.out.println("上" + money + "个小时的网放松一下"));
    }

    public void happy(double money, Consumer<Double> con) {
        con.accept(money);
    }

    @Test
    public void test1() {
        List<String> integers = Arrays.asList("北京", "南京", "东京", "天津");
        List<String> filtertests = filtertest(integers, new Predicate<String>() {
            @Override
            public boolean test(String integer) {
                return integer.contains("京");
            }
        });
        System.out.println(filtertests);

        System.out.println("*************************");

        List<String> filtertest = filtertest(integers,integer-> integer.contains("京"));
        System.out.println(filtertest);
    }

    public List<String> filtertest(List<String> arr, Predicate<String> pre) {
        List<String> integers = new ArrayList<>();
        for (String i : arr) {
            if (pre.test(i)) {
                integers.add(i);
            }
        }
        return integers;
    }
}

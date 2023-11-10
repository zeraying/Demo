package javase.Features;

import org.junit.Test;

import java.util.Comparator;

/**
 * @author pzy
 * @create 2023-09-28-11:52
 * @function Lambda表达式
 * 要求：接口中只有一个抽象方法
 * 本质上是作为函数式接口的实例
 * 如果接口中只声明了一个抽象方法，就称这个接口为函数式接口
 * 匿名实现类都可以用Lambda表达式来写
 * OOF 面向函数式编程
 * OOP 面向对象编程
 * AOP 面向切面编程
 */
public class LambdaTest {
    @Test
    public void test1() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world");
            }
        };
        runnable.run();
        System.out.println("*********************");
//        如果抽象方法中只有一行代码，可以省略方法体的大括号，当然，如果不止一行，就不能省略
        Runnable runnable1 = () -> System.out.println("你好，世界");
        runnable1.run();
    }

    @Test
    public void test2() {
        Comparator<Integer> integerComparator = new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        int a = integerComparator.compare(1, 2);
        System.out.println(a);
        System.out.println("***********************");
//        有返回值的方法，如果要去掉大括号，还需要去掉return关键字；
//        数据类型可以省略，因为编译器可以做类型推断
//        当表达式只有一个参数存在时左边的括号可以取消
        Comparator<Integer> integerComparator1 = (o1, o2) -> (o1 - o2);
        int b = integerComparator1.compare(21, 12);
        System.out.println(b);
        System.out.println("***********************");
//        方法引用
        Comparator<Integer> integerComparator2 = Integer::compare;
        int c = integerComparator2.compare(11, 11);
        System.out.println(c);
    }
}

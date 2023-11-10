package javase.Features;

import javase.IO.person;
import org.junit.Test;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author pzy
 * @create 2023-10-01-12:49
 * @function
 * 一，构造器引用
 *      和方法引用类似，函数式接口的抽象方法的形参列表和构造器的形参列表一致。
 *      抽象方法的返回值类型即为构造器所属的类型。
 * 二，数组引用
 *      把数组看成是一个特殊的类，则写法与构造器引用一致。
 */
public class ConstructorRefTest {
    //    构造器引用
//    Suoolier中的T get()
//    person的空参构造器：person()
    @Test
    public void test1() {
        Supplier<person> sup = new Supplier<person>() {
            @Override
            public person get() {
                return new person();
            }
        };
        System.out.println(sup.get());
        System.out.println("*******************");
        Supplier<person> sup1 = () -> new person();
        System.out.println(sup1.get());
        System.out.println("*******************");
        Supplier<person> sup2 = person::new;
        System.out.println(sup2.get());
    }

    //    数组引用
    @Test
    public void test2() {
        Function<Integer, String[]> func1 = length -> new String[length];
        String[] apply = func1.apply(5);
        System.out.println(Arrays.toString(apply));
        System.out.println("*******************");
        Function<Integer, String[]> func2 = String[]::new;
        String[] apply1 = func2.apply(6);
        System.out.println(Arrays.toString(apply1));
    }
}

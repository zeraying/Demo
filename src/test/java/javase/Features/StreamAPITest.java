package javase.Features;

import javase.IO.person;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author pzy
 * @create 2023-10-07-11:21
 * @function
 * 1.Stream是对数据的运算，与CPU打交道
 * 集合是对数据的存储，与内存打交道
 * 2.Stream自己不会存储元素
 * Stream不会改变源对象，相反，他们会返回一个持有结果的新Stream
 * Stream操作是延迟执行的，意味着他们会等到需要结果是才执行
 * 3.Stream执行流程
 * Stream的实例化
 * 一系列中间操作（过滤，映射。。。）
 * 总之操作
 * 4.说明：
 * 一个中间操作链，对数据源的数据进行处理
 * 一旦执行中间操作，就执行中间操作链并产生结果。之后不再被使用。
 */
public class StreamAPITest {
    //    创建Stream的方式一：通过集合
//    创建Stream的方式二：通过数组
    @Test
    public void test1() {
        int[] ints = {1, 2, 3, 4, 5, 6};
//      使用Arrays类的 static <T> Stream<T> stream(T[] array) 返回一个流
        IntStream stream = Arrays.stream(ints);
        person person = new person("tom", 10);
        person person1 = new person("jack", 11);
        person[] arr1 = new person[]{person, person1};
        Stream<javase.IO.person> stream1 = Arrays.stream(arr1);
//        filter 从流中排除某些元素
//        limit(n) 使元素个数不超过n
//        skip(n) 跳过前n个元素
//        distinct 去除重复元素
        stream1.filter(e->e.getAge()>10).forEach(System.out::println);
    }

    //    创建Stream的方式三：通过stream的of()
    @Test
    public void test2() {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6);
    }

    //    创建Stream的方式二：创建无限流
    @Test
    public void test3() {
//        迭代
        Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out::println);
//        生成
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }
}

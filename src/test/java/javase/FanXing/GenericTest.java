package javase.FanXing;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author pzy
 * @create 2023-09-16-20:58
 * @function 泛型
 */
public class GenericTest {

    @Test
    public void test1(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(12);
        list.add(43);
        list.add(645);
//        问题一：可能会混入不同类型的元素
        list.add("aa");
        for (Object o : list) {
//        问题二：强转时，可能出现类型转换异常
            int o1 = (Integer) o;
            System.out.println(o1);
        }
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        list1.add(123);
        list1.add(12);
        list1.add(43);
        list1.add(645);
        for (Integer integer : list1) {
            System.out.println(integer);
        }
        Iterator<Integer> iterator = list1.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
//        限制了添加的元素必须为Integer类型
//        list1.add("dsdd");
    }
}

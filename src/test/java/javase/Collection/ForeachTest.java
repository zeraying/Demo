package javase.Collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * @author pzy
 * @create 2023-09-12-17:35
 * @function foreach遍历集合和数组
 */
public class ForeachTest {
    @Test
    public void test1() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add("集合");
        coll.add(new person("小明", 12));
        coll.add(890);
        for (Object obj : coll) {
            System.out.println(obj);
        }
    }

    @Test
    public void test2() {
        int[] a = new int[]{1, 2, 3, 4, 5, 6};
//        修改当前i的值不会改变原数组
        for (int i : a) {
            System.out.println(i);
        }
        System.out.println(Math.PI);
    }

    @Test
    public void test3() {
        Integer[] a = new Integer[]{1, 2, 3, 4, 5, 6};
        ArrayList list = new ArrayList();
        list.addAll(Arrays.stream(a).toList());
        System.out.println(list);
//        在remove()中直接传入值是删除的索引，转为Integer类型是删除值
        list.remove(Integer.valueOf(3));
//        list.remove(2);
        System.out.println(list);
    }
}

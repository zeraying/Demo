package javase.Collection;

import org.junit.Test;

import java.util.*;

/**
 * @author pzy
 * @create 2023-09-13-11:28
 * @function HashSet的底层是数组加链表
 *              1.无序性:无序性并不是指数据随机输出，HashSet在添加数据时，根据数据的hashcode值计算数据的存放位置，第一次hashset的长度为16，
 *                  hashcode值对16取余即为数据存放的位置，当出现相同时，调用重写的equals方法比较是否相同，不同则将两个数据以链表连接，
 *                  当数据存放了数据长度的0.75时，hashset扩容为原来的2倍。
 *              2.不重复性:数据在存入时调用了hashcode方法和equals方法保证了数据的不可重复性。
 *           LinkedHashSet:
 *              1.是hashset的一个子类，在hashset的基础上将存入的数据存入了一个双向链表中，使得数据顺序输出，该链表是独立于HashSet的。本质上还是无序的
 */
public class SetTest {
    @Test
    public void test(){
        HashSet<Object> hashSet = new HashSet<>();
        hashSet.add(123);
        hashSet.add(234);
        hashSet.add("aa");
        hashSet.add(new person("tom",23));
        hashSet.add(123);
        hashSet.add("vv");
        hashSet.add(new person("tom",23));
//        System.out.println(hashSet);
        for (Object o : hashSet) {
            System.out.println(o);
        }
    }
    @Test
    public void test1(){
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(123);
        linkedHashSet.add(234);
        linkedHashSet.add("aa");
        linkedHashSet.add(new person("tom",23));
        linkedHashSet.add(123);
        linkedHashSet.add("vv");
        linkedHashSet.add(new person("tom",23));
        System.out.println(linkedHashSet);
    }

    @Override
    public String toString() {
        return "SetTest{}";
    }
}

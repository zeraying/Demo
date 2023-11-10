package javase.Collection;

import org.junit.Test;

import java.util.*;

/**
 * @author pzy
 * @create 2023-09-15-17:45
 * @function TreeMap
 */
public class TreeMapTest {
    //    向TreeMap中添加key-value，要求key必须是由同一个类创建的对象
//    应为要按照key进行排序：自然排序，自定义排序
    @Test
    public void test() {
        TreeMap treeMap = new TreeMap();
        person person1 = new person("Jack", 12);
        person person2 = new person("Tom", 34);
        person person3 = new person("Marry", 5);
        person person4 = new person("Mark", 7);
        person person5 = new person("Lucy", 1);
        person person6 = new person("Sandy", 78);
        treeMap.put(person1, 78);
        treeMap.put(person2, 90);
        treeMap.put(person3, 45);
        treeMap.put(person4, 99);
        treeMap.put(person5, 12);
        treeMap.put(person6, 56);
        Set set = treeMap.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test1() {
        TreeMap tree = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof person && o2 instanceof person) {
                    person per = (person) o1;
                    person per1 = (person) o2;
                    return per.getAge() - per1.getAge();
                }
                throw new RuntimeException("数据类型不一致");
            }
        });
        person person1 = new person("Jack", 12);
        person person2 = new person("Tom", 34);
        person person3 = new person("Marry", 5);
        person person4 = new person("Mark", 7);
        person person5 = new person("Lucy", 1);
        person person6 = new person("Sandy", 78);
        tree.put(person1, 78);
        tree.put(person2, 90);
        tree.put(person3, 45);
        tree.put(person4, 99);
        tree.put(person5, 12);
        tree.put(person6, 56);
        Set set = tree.entrySet();
        for (Object obj : set) {
            System.out.println(obj);
        }
    }
}

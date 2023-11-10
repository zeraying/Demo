package javase.Collection;

import org.junit.Test;

import java.util.*;

/**
 * @author pzy
 * @create 2023-09-14-17:46
 * @function
 */
public class MapTest {
    @Test
    public void test() {
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("4", "DD");
        hashMap.put("2", "BB");
        hashMap.put("3", "CC");
        hashMap.put("1", "AA");
        hashMap.put("6", "FF");
        hashMap.put("5", "EE");
//        System.out.println(hashMap);
        HashMap<Object, Object> hashMap1 = new HashMap<>();
        hashMap1.putAll(hashMap);
//        相当于下面这一条语句
//        HashMap<Object, Object> hashMap1 = new HashMap<>(hashMap);
//        出现相同键的数值对象时，put方法体现了修改的作用
        hashMap1.put("3", "gt");
        hashMap1.put("7", "xd");
//        System.out.println(hashMap1);
//        根据键来移除键值对
        hashMap1.remove("3");
        hashMap1.clear();
        System.out.println(hashMap1);
        System.out.println(hashMap1.size());//该操作与map = null不同
    }

    @Test
    public void test1() {
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("4", "DD");
        hashMap.put("2", "BB");
        hashMap.put("3", "CC");
        hashMap.put("1", "AA");
        hashMap.put("8", "FF");
        hashMap.put("5", "EE");
        hashMap.put("3", "gt");
        hashMap.put("7", "xd");
//        根据键来取值
        System.out.println(hashMap.get("3"));
        System.out.println(hashMap.containsKey("6"));
        System.out.println(hashMap.containsValue("EE"));
        hashMap.clear();
        System.out.println(hashMap.isEmpty());
    }

    @Test
    public void test2() {
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("4", "DD");
        hashMap.put("2", "BB");
        hashMap.put("3", "CC");
        hashMap.put("1", "AA");
        hashMap.put("8", "FF");
        hashMap.put("5", "EE");
        hashMap.put("3", "gt");
        hashMap.put("7", "xd");
//        hashMap不能直接调用迭代器，根据key值或value值对Map进行遍历
        Set<Object> set = hashMap.keySet();
        Iterator<Object> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("----------");
        Collection<Object> values = hashMap.values();
        for (Object obj : values) {
            System.out.println(obj);
        }
        System.out.println("----------");
//        遍历所有的key-value
        Set<Map.Entry<Object, Object>> set1 = hashMap.entrySet();
        Iterator<Map.Entry<Object, Object>> iterator1 = set1.iterator();
//        entrySet集合中的元素都是一个entry元素
        while(iterator1.hasNext()){
//            Map.Entry<Object, Object> next = iterator1.next();
//            System.out.println(next);
              System.out.println(iterator1.next());
        }
    }
}

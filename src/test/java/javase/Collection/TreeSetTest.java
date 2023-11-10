package javase.Collection;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author pzy
 * @create 2023-09-13-16:46
 * @function TreeSet
 */
public class TreeSetTest {
    @Test
    public void test1(){
//        TreeSet treeSet = new TreeSet();
//        在TreeSet集合中只能存放属于相同类的数据
//        treeSet.add(12);
//        treeSet.add("aa");
//        treeSet.add(56);
//        treeSet.add(new person("tom","12"));
//        treeSet.add("bb");
//        treeSet.add(new person("tom","12"));
//        System.out.println(treeSet);
//        数据在存入集合中时，集合会自动对其进行排序
//        treeSet.add(12);
//        treeSet.add(-57);
//        treeSet.add(56);
//        treeSet.add(34);
//        treeSet.add(11);
//        treeSet.add(1);
//        System.out.println(treeSet);
//        当TreeSet中传入某类的数据时，该类须实现了Compare(自然排序)接口或Comparator(自定义排序)接口
//        当实现的Compare接口只对一种数据进行定义，当CompareTo返回零时，被认为是相同数据不加入集合
        TreeSet treeSet1 = new TreeSet();
        treeSet1.add(new person("tom",12));
        treeSet1.add(new person("cat",11));
        treeSet1.add(new person("join",45));
        treeSet1.add(new person("cat",78));
        treeSet1.add(new person("mouse",-12));
        treeSet1.add(new person("apple",56));
//        System.out.println(treeSet1);
        Iterator iterator = treeSet1.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    @Test
    public void test2(){
        Comparator<Object> comparator = new Comparator<>() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof person && o2 instanceof person) {
                    person p1 = (person) o1;
                    person p2 = (person) o2;
                    return p1.getAge()-p2.getAge();
                }
                throw new RuntimeException("数据类型不符");
            }
        };
        TreeSet<Object> objects = new TreeSet<>(comparator);
        objects.add(new person("tom",12));
        objects.add(new person("cat",11));
        objects.add(new person("join",45));
        objects.add(new person("cat",78));
        objects.add(new person("mouse",-12));
        objects.add(new person("apple",56));
        Iterator<Object> iterator = objects.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}

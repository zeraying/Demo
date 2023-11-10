package javase.Collection;

import org.junit.Test;

import java.util.*;

/**
 * @author pzy
 * @create 2023-09-11-11:06
 * @function Collection集合的各种操作
 */
public class CollectionTest {
    @Test
    public void colltest() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add("集合");
        coll.add(new person("小明", 12));
        coll.add("");
//        判断时会调用object对象所在类的equals方法，若不重写则比较的是地址值返回false
        System.out.println(coll.contains(new person("小明", 12)));
        Collection coll1 = new ArrayList();
        int[] i = new int[]{456, 123};
        /**
         * 1.Arrays.asList()可以插入null，而List.of()不可以
         * 2.用List.of的List自然是不包含null，而用Arrays.asList的List包含null。
         * 3.List.of生成的List不能修改，Arrays.asList生成的List能修改。
         * 4.关于数组修改对List的影响。数组修改对Arrays.asList生成的List有影响，对List.of生成的List无影响
         */
//        List<int[]> ints = Arrays.asList(i);
//        List<int[]> i1 = List.of(i);
//        直接将int型的数组转化为集合时，传入的是一个数组型的元素，需将int型的数组转化为Integer型的数组
        Integer[] it = Arrays.stream(i).boxed().toArray(Integer[]::new);
//        Integer[] itg = new Integer[]{456,123};
        List<Integer> integers = Arrays.asList(it);
        coll1.addAll(integers);
//        containsAll传入的是集合

        System.out.println(coll.containsAll(coll1));
    }

    @Test
    public void coltest1() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add("集合");
//         想要输出具体的属性值，需要重写toString方法
        coll.add(new person("小明", 12));
        coll.add(890);
        System.out.println(coll.hashCode());
        System.out.println(coll.isEmpty());
//         迭代器遍历集合
//        Iterator iterator = coll.iterator();
//        while (iterator.hasNext()) {
////             hasNext，next各有一个指针
//            System.out.println(iterator.next());
//        }
        Iterator iterator1 = coll.iterator();
        while (iterator1.hasNext()) {
            Object next = iterator1.next();
            if ("集合".equals(next)) {
//                未调用next()之前调用remove()，指针未指到具体实例
                iterator1.remove();
            }
        }
//         集合每次调用iterator()都会返回一个新的迭代器对象，默认指针在游标的第一个元素之前
        iterator1 = coll.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }
    }

    @Test
    public void test2() {
        ArrayList coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add("集合");
        coll.add(new person("小明", 12));
        coll.add("AA");
//        Collection集合中不含subList()方法
        List coll1 = coll.subList(2, 4);
        System.out.println(coll1);
        coll.set(1, "CC");
        System.out.println(coll);
    }
}


class person implements Comparable {
    private String name;
    private int age;

    public person() {
    }

    public person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public boolean equals(Object o) {
        //        System.out.println("调用equals方法");
        if (this == o) return true;
        if (!(o instanceof person person)) return false;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof person) {
            person o1 = (person) o;
            int a = this.name.compareTo(o1.name);
            if (a != 0) {
                return a;
            } else {
//                person o2 = (person) o;
                return this.age-o1.age;
            }
        } else {
            throw new RuntimeException("数据类型不匹配");
        }
    }
}

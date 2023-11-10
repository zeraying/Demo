package javase.FanXing;

import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author pzy
 * @create 2023-09-18-11:15
 * @function
 */
public class GenericTest1 {
    public static void main(String[] args) {
//        当实例化对象时，如果指明了泛型的类型后，对象的泛型就为该类型
        person<Integer, String> person = new person<>("sandy", 123, "2022");
        person<String, Integer> person1 = new person<>("lucy", "456", 2023);
        Integer[] a = new Integer[]{1,2,3,4,5};
        System.out.println(person.test(a));
    }
    @Test
    public void test(){
        List<Object> list1 = null;
        List<String> list2 = null;
//       ?是通配符,对于list<?>就不能向其内部添加数据，除了添加null
        List<?> list =null;

        list = list1;
        list = list2;
//        允许读取数据，读取的数据类型为Object
        Object o = list.get(0);
    }
    public void print(List<?> list){
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()){
            Object o = iterator.next();
            System.out.println(o);
        }
    }
}

class person<T1, T2> {
    private String name;
    private T1 age;
    private T2 time;

    public person() {
    }

    public person(String name, T1 age, T2 time) {
        this.name = name;
        this.age = age;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T1 getAge() {
        return age;
    }

    public void setAge(T1 age) {
        this.age = age;
    }

    public T2 getTime() {
        return time;
    }

    public void setTime(T2 time) {
        this.time = time;
    }

//    泛型方法：方法中出现了泛型的结构，但泛型参数与类的泛型参数没有任何关系
//    泛型方法可以声明为static的泛型类不行

    public <E> List<E> test(E[] arr) {
        return Arrays.stream(arr).toList();
    }
}

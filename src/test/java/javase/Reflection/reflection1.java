package javase.Reflection;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author pzy
 * @create 2023-09-25-20:03
 * @function 反射
 * 获取java.lang.Class的实例(获取类的字节码文件)
 * 1.Class.forName()
 * 2.对象.getClass()
 * 3.任何类型.class
 */
public class reflection1 {
    //    调用反射之前
    @Test
    public void test1() {
        person person = new person("tom", 20);
        person.age = 22;
        System.out.println(person.toString());
        person.show();
//        在perrson类外部，不能通过其对象调用内部私有结构，及私有的构造器
    }

    //    调用反射之后
    @Test
    public void test2() throws Exception {
        Class aClass = person.class;
//        反射创建person类的对象
        Constructor cons = aClass.getConstructor(String.class, int.class);
//        newInstance()方法内部实际上调用了无参数构造方法，必须保证无参构造存在
        Object tom = cons.newInstance("tom", 20);
        person tom1 = (person) tom;
        System.out.println(tom1);
//        反射调用person类的属性,方法
        Field age = aClass.getDeclaredField("age");
        age.set(tom1, 10);
        System.out.println(tom1);
        Method show = aClass.getDeclaredMethod("show");
        show.invoke(tom1);

        System.out.println("*************");

//        通过反射可以调用person类中私有的属性，方法，构造器,
//        都在原有的基础上调用了setAccessible()方法,默认false，设置为true为打破封装
//        私有的构造器
        Constructor constructor = aClass.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);
        person person = (person) constructor.newInstance("jack");
        System.out.println(person);
//        私有的属性,在原有的基础上调用了setAccessible()方法
        Field name = aClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(person, "rouse");
        System.out.println(person);
//        私有的方法
        Method show1 = aClass.getDeclaredMethod("show1", String.class);
        show1.setAccessible(true);
        String invoke = (String) show1.invoke(person, "参数");
        System.out.println(invoke);
    }

//    获取class实例的几种方式
    @Test
    public void test3() throws ClassNotFoundException {
//        方式一：调用运行时类的属性.class
        Class aClass = person.class;
        System.out.println(aClass);
//        方式二：通过运行时类的对象调用getClass()
        person person = new person();
        Class aClass1 = person.getClass();
        System.out.println(aClass1);
//        方式三：调用Class的静态方法：forName(Sting classPath)
        Class aClass2 = Class.forName("javase.Reflection.person");
        System.out.println(aClass2);
        System.out.println(aClass == aClass1);
        System.out.println(aClass == aClass2);
    }
}

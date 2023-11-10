package javase.Reflection;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author pzy
 * @create 2023-09-26-19:44
 * @function 获取nb
 */
public class OtherTest {
    //    获取构造器结构
    @Test
    public void test1() {
        Class<person1> aClass = person1.class;
//        getConstructors()：获取当前运行时类中声明为public的构造器
        Constructor<?>[] constructors = aClass.getConstructors();
        for (Constructor c : constructors) {
            System.out.println(c);
        }
        System.out.println();
//        getDeclaredConstructors():获取当前运行时类中声明的所有的构造器
        Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
        for (Constructor c : declaredConstructors) {
            System.out.println(c);
        }
    }

    //    获取运行时类的父类
    @Test
    public void test2() {
        Class<person1> aClass = person1.class;

        Class<? super person1> superclass = aClass.getSuperclass();
        System.out.println(superclass);
    }

    //    获取运行时类的带泛型父类
    @Test
    public void test3() {
        Class<person1> aClass = person1.class;

        Type genericSuperclass = aClass.getGenericSuperclass();
        System.out.println(genericSuperclass);
    }

    //    获取运行时类的带泛型父类的泛型
    @Test
    public void test4() {
        Class<person1> aClass = person1.class;

        Type genericSuperclass = aClass.getGenericSuperclass();
        ParameterizedType paramType = (ParameterizedType) genericSuperclass;
        Type[] typeArguments = paramType.getActualTypeArguments();
        for (Type t : typeArguments) {
            System.out.println(t.getTypeName());
        }
    }

    //    获取运行时类的接口
    @Test
    public void test5() {
        Class<person1> aClass = person1.class;

        Class<?>[] interfaces = aClass.getInterfaces();
        for (Class c : interfaces) {
            System.out.println(c);
        }
        System.out.println();
        //    获取运行时类父类的接口
        Class<?>[] interfaces1 = aClass.getSuperclass().getInterfaces();
        for (Class c : interfaces1) {
            System.out.println(c);
        }
    }

    //    获取运行时类的接口
    @Test
    public void test6() {
        Class<person1> aClass = person1.class;

        Package aPackage = aClass.getPackage();
        System.out.println(aPackage);
    }
}
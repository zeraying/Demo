package javase.Reflection;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author pzy
 * @create 2023-09-27-10:49
 * @function
 */
public class reflectionTest {
    @Test
    public void test1() throws Exception {
        Class<person1> aClass = person1.class;
//        创建运行时类的对象
        person1 person1 = (person1) aClass.newInstance();
//        getDeclaredField()获取运行时类中指定变量名的属性
        Field name = aClass.getDeclaredField("name");
//        突破属性的封装性
        name.setAccessible(true);
//        获取指定对象的属性值
        name.set(person1,"tom");
        System.out.println(name.get(person1)); 

    }
    @Test
    public void test2() throws Exception {
        Class<person1> aClass = person1.class;
        person1 person1 = (person1) aClass.newInstance();
        Method show = aClass.getDeclaredMethod("show", String.class);
//        保证该方法是可访问的
        show.setAccessible(true);
//        对方法进行调用
//        invoke()的返回值即为对应类中调用的方法的返回值
        Object invoke = show.invoke(person1, "CHN");
        System.out.println(invoke);
        System.out.println("*********静态方法事物调用**********");
        Method showDesc = aClass.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);
        Object invoke1 = showDesc.invoke(person1);
//        调用没有返回值的方法的invoke()的返回值为null
        System.out.println(invoke1);
    }
}

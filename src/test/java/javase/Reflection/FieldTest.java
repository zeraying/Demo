package javase.Reflection;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author pzy
 * @create 2023-09-26-17:30
 * @function 获取当前运行时类的所有属性结构
 */
public class FieldTest {
    @Test
    public void test1() {
        Class<person1> aClass = person1.class;
//        获取属性结构
//        getFields()：获取当前运行时类及其父类中声明为public访问权限的属性
        Field[] fields = aClass.getFields();
        for (Field f : fields) {
            System.out.println(f);
        }
        System.out.println();
//        getDeclaredFields():获取当前运行时类中声明的所有属性(不包含父类中声明的属性)
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field f : declaredFields) {
            System.out.println(f);
        }
    }

    @Test
    public void test2() {
        Class<person1> aClass = person1.class;
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field f : declaredFields) {
//         权限修饰符
            int modifiers = f.getModifiers();
            System.out.println(Modifier.toString(modifiers) + "\t");

//         数据类型
            Class<?> type = f.getType();
            System.out.println(type.getName() + "\t");

//         变量名
            String name = f.getName();
            System.out.println(name);

            System.out.println( );
        }
    }
}

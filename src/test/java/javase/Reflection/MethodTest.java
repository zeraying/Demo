package javase.Reflection;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author pzy
 * @create 2023-09-26-19:29
 * @function 获取运行时类的方法结构
 */
public class MethodTest {
    @Test
    public void test1() {
        Class<person1> aClass = person1.class;
//        获取当前运行时类及其所有父类中声明为public的方法
        Method[] methods = aClass.getMethods();
        for (Method m : methods) {
            System.out.println(m);
        }
        System.out.println("*******************");
//        获取当前运行时类中声明的所有方法，不包含父类
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method m : declaredMethods) {
            System.out.println(m);
        }
    }

    /**
     * @xxxx 权限修饰符 返回值类型 方法名(参数类型， 参数。。。)throws xxxException{}
     */
    @Test
    public void test2() {
        Class<person1> aClass = person1.class;
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method m : declaredMethods) {
//            获取方法声明的注解
            Annotation[] annotations = m.getAnnotations();
            for (Annotation a : annotations) {
                System.out.println(a);
            }
//            获取权限修饰符
            int modifiers = m.getModifiers();
            System.out.print(Modifier.toString(modifiers) + "\t");
//            获取返回值类型
            System.out.print(m.getReturnType().getName() + "\t");
//            获取方法名
            System.out.print(m.getName() + "\t");
//            获取形参列表
            System.out.print("(");
            Class<?>[] parameterTypes = m.getParameterTypes();
            if (!(parameterTypes == null && parameterTypes.length == 0)) {
                for (int i = 0; i < parameterTypes.length; i++) {
                    if (i == parameterTypes.length - 1) {
                        System.out.print(parameterTypes[i].getName() + "args_" + i);
                        break;
                    }
                    System.out.print(parameterTypes[i].getName() + "args_" + i + ",");

                }
            }
            System.out.print(")" + "\t");
//        获取抛出的异常
            Class<?>[] exceptionTypes = m.getExceptionTypes();
            if (exceptionTypes.length > 0) {
                System.out.println("throw");
                for (int i = 0; i < exceptionTypes.length; i++) {
                    if (i == exceptionTypes.length - 1) {
                        System.out.println(exceptionTypes[i].getName());
                        break;
                    }
                }
            }
        }
    }
}
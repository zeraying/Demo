package javase.Reflection;

import org.junit.Test;

import java.util.Random;

/**
 * @author pzy
 * @create 2023-09-25-23:08
 * @function 通过反射创建运行时类的对象
 * 要求：
 * 1.运行时类必须提供空参构造器
 * 2.空参构造器的访问权限通常设为public
 * 在javabean中要求提供一个public的空参构造器原因：
 * 1.便于通过反射，创建运行时类的对象
 * 2.便于子类继承此运行时类时，默认调用super()时，保证父类有此构造器
 */
public class NewInstanceTest {
    @Test
    public void test1() throws Exception {
        Class<person> aClass = person.class;
//newInstance():调用此方法创建运行时类的对象，内部调用了运行时类的空参构造器
        person person = aClass.newInstance();
        System.out.println(person);
    }

    /**
     * 创建一个指定类的对象
     * classpath:指定类的全类名
     */
    @Test
    public void test2(){
        int i = new Random().nextInt(3);
        String classpath = "";
        switch (i){
            case 0:
                classpath = "java.util.Date";
                break;
            case 1:
                classpath = "java.lang.Object";
                break;
            case 2:
                classpath = "javase.Reflection.person";
                break;
        }
        Object o = null;
        try {
            o = getInstance(classpath);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(o);
    }
    public Object getInstance(String classpath) throws Exception {
        Class aClass = Class.forName(classpath);

        return aClass.newInstance();
    }
}

package javase.Reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author pzy
 * @create 2023-09-27-22:05
 * @function 动态代理
 */
interface Human {
    String getBelief();

    void eat(String food);
}

//被代理类
class SuperMan implements Human {

    @Override
    public String getBelief() {
        return "i can fly";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃" + food);
    }
}
//AOP:面向切面编程，采取横向抽取机制，将各个方法中的重复代码提取出来，在程序编译或运行时，将提取出来的代码应用到需要执行的地方。
class HumanUtil{
    public void method1(){
        System.out.println("=============通用方法一=============");
    }
    public void method2(){
        System.out.println("=============通用方法二=============");
    }
}
//代理类
class ProxyFactory {
    //   返回一个代理类的对象，根据加载到内存中的被代理类，动态的创建一个代理类及其对象
    public static Object getProxyInstance(Object obj) {//obj:被代理类的对象
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
    }
}

class MyInvocationHandler implements InvocationHandler {
    private Object obj;

    //    为obj赋值，获取的是被代理的对象
    public void bind(Object obj) {
        this.obj = obj;
    }

    //    当我们通过代理类的对象调用方法时，就会调用如下的方法：invoke()
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        method即为代理类对象调用的方法，此方法也就作为了被代理类对象要调用的方法
        HumanUtil util = new HumanUtil();
        util.method1();
        Object invoke = method.invoke(obj, args);
        util.method2();
        return invoke;
    }
}

public class ProxyTest {
    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
//        proxyInstance代理类的对象
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);
//        当通过代理类对象调用方法时，会自动的调用被代理类类中同名的方法
        String belief = proxyInstance.getBelief();
        System.out.println(belief);
        proxyInstance.eat("食物");
        System.out.println("***********************");
        NikeClothFactory nike = new NikeClothFactory();
        ClothFactory proxyInstance1 = (ClothFactory) ProxyFactory.getProxyInstance(nike);
        proxyInstance1.produceCloth();
    }
}

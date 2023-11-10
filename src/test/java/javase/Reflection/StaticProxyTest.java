package javase.Reflection;

/**
 * @author pzy
 * @create 2023-09-27-21:41
 * @function 静态代理类
 * 特点：代理类和被代理类在编译期间就确定下来了
 * 双方同时实现同一个接口
 */
interface ClothFactory {
    void produceCloth();
}

//代理类
class ProxyClothFactory implements ClothFactory {
    private ClothFactory factory;

    public ProxyClothFactory(ClothFactory factory) {
        this.factory = factory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工厂做一些准备工作");
        factory.produceCloth();
        System.out.println("代理工厂做一些后续的收尾工作");
    }
}

//被代理类
class NikeClothFactory implements ClothFactory {
    @Override
    public void produceCloth() {
        System.out.println("Nike工厂生产一批运动服");
    }
}

public class StaticProxyTest {
    public static void main(String[] args) {
//        创建被代理类的对象
        NikeClothFactory nike = new NikeClothFactory();
//        创建代理类的对象
        ProxyClothFactory proxyClothFactory = new ProxyClothFactory(nike);
        proxyClothFactory.produceCloth();
    }
}

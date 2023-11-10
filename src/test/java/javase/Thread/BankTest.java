package javase.Thread;

/**
 * @author pzy
 * @create 2023-08-21-19:14
 * @TODO 解决单列模式中懒汉式的线程不安全问题
 */
class bank {
    private bank() {
    }

    private static bank instance = null;

    public static bank getInstance() { //该方法不能通过创建对象来调用，声明为static来通过类调用
//      方式一:效率低，所有的线程都需要进入同步代码块
//        synchronized (bank.class) {
//            if (instance == null) {
//                instance = new bank();
//            }
//        }
//        return instance;
//      方式二:当第一个线程赋值后，后续线程直接使用instance
        if (instance == null) {
            synchronized (bank.class) {
                if (instance == null) {
                    instance = new bank();
                }
            }
        }
        return instance;
    }
}

public class BankTest {
}

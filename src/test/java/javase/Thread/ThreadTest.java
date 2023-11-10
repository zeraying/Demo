package javase.Thread;

/**
 * @author pzy
 * @create 2023-08-18-11:01
 * @TODO 创建一个线程
 * 1. 创建一个继承于Thread的类
 * 2. 重写run方法
 * 3. 创建继承于Thread的类的对象
 * 4. 调用start方法
 */
class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

class MyThread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
//        创建新的对象开启多个线程
        MyThread1 myThread1 = new MyThread1();
        MyThread myThread = new MyThread();
        myThread.start();
//        不能通过调run()的方式启动线程
//        myThread.run();
        myThread1.start();
//        创建Thread类的匿名子类的方式启动新线程
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 != 0) {
                        System.out.println(Thread.currentThread().getName() + ":" + "*");
                    }
                }
            }
        }.start();
//        主线程
        Thread.currentThread().setName("主线程");
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

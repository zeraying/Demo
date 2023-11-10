package javase.Thread;

/**
 * @author pzy
 * @create 2023-08-19-12:13
 * @TODO 用创建线程的两种方式来实现买票{①继承Thread类，②实现runnable接口}(同步代码块)
 */
//①继承Thread类
class MThread extends Thread {
    private static int ticket = 100;

    //    private static Object object = new Object();
//继承Thread类后需要重写Thread类中的run方法
    @Override
    public void run() {
//用while循环保证线程能一直执行
        while (true) {
//用 synchronizde修饰代码块防止被多个线程同时执行，同一时刻只有一个线程执行同步代码块，保证单线程操作
//MThread.class是同步监视器，任何一个对象都可以充当同步监视器，多个线程共用一个同步监视器
//MThread.class类也是对象
            synchronized (MThread.class) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(getName() + ":" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}

//②实现runnable接口
class Window implements Runnable {
    private int ticket1 = 100;

    @Override
    public void run() {
        while (true) {
//this同步监视器指当前类创建的对象
            synchronized (this) {
                if (ticket1 > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + ticket1);
                    ticket1--;
                } else {
                    break;
                }
            }
        }
    }
}

public class MaiPiao {
    public static void main(String[] args) {
        MThread mThread = new MThread();
        MThread mThread1 = new MThread();
        MThread mThread2 = new MThread();
        mThread.start();
        mThread1.start();
        mThread2.start();
//        Window window = new Window();
//        Thread thread = new Thread(window);
//        Thread thread1 = new Thread(window);
//        Thread thread2 = new Thread(window);
//        thread.start();
//        thread1.start();
//        thread2.start();
    }
}

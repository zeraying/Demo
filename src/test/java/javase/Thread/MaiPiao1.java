package javase.Thread;

/**
 * @author pzy
 * @create 2023-08-21-18:16
 * @TODO 买票(同步方法)
 */
class MThread1 extends Thread {
    private static int ticket = 100;

    @Override
    public void run() {
        while (true) {
            show1();
        }
    }

    public static synchronized void show1() { //将此方法设为静态的，为了只有一个同步监视器
//        public synchronized void show1() {//该同步监视器：mThread，mThread1，mThread2。不对
        if (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + ":" + ticket);
            ticket--;
        }
    }
}

class Window1 implements Runnable {
    private int ticket1 = 100;

    @Override
    public void run() {
        while (true) {
            show();

        }
    }

    public synchronized void show() { // 同步监视器：this
        if (ticket1 > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + ":" + ticket1);
            ticket1--;
        }
    }
}

public class MaiPiao1 {
    public static void main(String[] args) {
        MThread1 mThread = new MThread1();
        MThread1 mThread1 = new MThread1();
        MThread1 mThread2 = new MThread1();
        mThread.start();
        mThread1.start();
        mThread2.start();
//        Window1 window = new Window1();
//        Thread thread = new Thread(window);
//        Thread thread1 = new Thread(window);
//        Thread thread2 = new Thread(window);
//        thread.start();
//        thread1.start();
//        thread2.start();
    }
}
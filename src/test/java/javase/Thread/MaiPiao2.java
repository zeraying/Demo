package javase.Thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author pzy
 * @create 2023-08-22-12:04
 * @TODO run：买票(lock锁方式解决线程安全)
 */
class MThread2 extends Thread {
    private static int ticket = 100;
//  创建锁
    private static ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + ticket);
                    ticket--;
                } else {
                    break;
                }
            } finally {
                lock.unlock();
            }
        }
    }
}

class Window2 implements Runnable {
//  创建锁
    private ReentrantLock lock = new ReentrantLock();
    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + ticket);
                    ticket--;
                } else {
                    break;
                }
            } finally {
                lock.unlock();
            }

        }
    }
}

public class MaiPiao2 {
    public static void main(String[] args) {
//        MThread2 mThread1 = new MThread2();
//        MThread2 mThread2 = new MThread2();
//        MThread2 mThread3 = new MThread2();
//        mThread1.start();
//        mThread2.start();
//        mThread3.start();
        Window2 window2 = new Window2();
        Thread thread1 = new Thread(window2);
        Thread thread2 = new Thread(window2);
        Thread thread3 = new Thread(window2);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

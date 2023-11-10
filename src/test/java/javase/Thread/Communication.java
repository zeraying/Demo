package javase.Thread;

/**
 * @author pzy
 * @create 2023-09-05-14:16
 * @function 线程通信，两个线程交替打印1到100
 */
class a implements Runnable {
    private int A = 0;

    @Override
    public synchronized void run() {

        while (true) {
//            synchronized (this) {
                notify();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if (A <= 100) {
                    System.out.println(Thread.currentThread().getName() + "打印" + A);
                    A++;
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    break;
//                }
            }
        }

    }
}

public class Communication {
    public static void main(String[] args) {
        a a = new a();
        Thread thread = new Thread(a);
        Thread thread1 = new Thread(a);
        thread.start();
        thread1.start();
    }
}

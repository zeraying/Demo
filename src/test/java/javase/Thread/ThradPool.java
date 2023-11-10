package javase.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author pzy
 * @create 2023-09-06-0:07
 * @function 创建线程的方式四  线程池
 * 好处：
 *      1.提高响应速度（减少创建新线程的时间）
 *      2.降低资源消耗（重复利用线程池中的线程，不需要每次都去创建）
 *      3.便于资源管理
 *          corePoolSize：核心池的大小
 *          maximumPoolSize：最大线程数
 *          keepAliveTime：线程没有任务时最多保持多长时间会停止
 */
class MemberThread implements Runnable {
    int sum;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName()+":"+i);
                sum += i;
            }
        }
    }
}

public class ThradPool {
    public static void main(String[] args) {
//      1.创建线程需要通过executors类中的newFixedThreadPool()来创建一个ExecutorService的对象，就是线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        //设置线程池的属性
        //ThreadPoolExecutor的父类实现了ExecutorService接口，对其强转
        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;//
//        System.out.println(service.getClass());//ExecutorService是一个接口，获取他的实现类
        service1.setCorePoolSize(15);
//        service1.setKeepAliveTime();
//      2.执行指定的线程操作，需要提供实现了Runnable接口或Callable接口的实现类的对象
        service.execute(new MemberThread());//适合用于Runnable
        service.execute(new MemberThread());
//        service.submit(Callable callable);//适合用于Callable
//      3.关闭连接池
        service.shutdown();
    }
}

package javase.Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author pzy
 * @create 2023-09-05-21:45
 * @function 创建线程的新方式三（callable方式）    jdk5.0新增
 */
//1.创建一个实现了Callable的实现类
class numThread implements Callable {
//2.实现call方法，将线程需要实现的操作声明在call()方法中
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}

public class ThreadNew {
    public static void main(String[] args) {
//3.创建callable接口实现类的对象
        numThread numThread = new numThread();
//4.将此callable接口实现类的对象作为参数传递到FutureTask构造器中，创建FutureTask对象
        FutureTask futureTask = new FutureTask(numThread);
//5.将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象，并start
        new Thread(futureTask).start();
        try {
            //6.获取callable中call()的返回值
            //get()返回值即为FutureTask构造器参数Callable实现类重写call()的返回值
            Object o = futureTask.get();
            System.out.println("总和为:" + o);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        Thread.State[] values1 = Thread.State.values();
        for (int i = 0; i < values1.length; i++) {
            System.out.println(values1[i]);
        }
    }
}

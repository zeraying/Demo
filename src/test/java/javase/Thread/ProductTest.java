package javase.Thread;

/**
 * @author pzy
 * @create 2023-09-05-20:10
 * @function 生产者生产产品，消费者消费产品，最多有20个产品
 */
class clerk {
    private int product = 0;

    public clerk(int product) {
        this.product = product;
    }

    public synchronized void doproduct() {
        if (product < 20) {
            product++;
            System.out.println(Thread.currentThread().getName() + "生产产品，剩余产品:" + product);
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public synchronized void runproduct() {
        if (product > 0) {
            product--;
            System.out.println(Thread.currentThread().getName() + "消耗产品，剩余产品" + product);
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Producter extends Thread {
    private clerk clerk;

    public Producter(clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            clerk.doproduct();
        }
    }
}

class Customer1 extends Thread {
    private clerk clerk;

    public Customer1(clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(120);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            clerk.runproduct();
        }
    }
}

public class ProductTest {
    public static void main(String[] args) {
        clerk clerk = new clerk(0);
        Producter producter = new Producter(clerk);
        Customer1 customer = new Customer1(clerk);
        producter.setName("生产者");
        producter.start();
        customer.setName("消费者");
        customer.start();
    }
}
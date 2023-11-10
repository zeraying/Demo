package javase.Thread;

/**
 * @author pzy
 * @create 2023-09-04-23:03
 * @function 两个人往一个账户中存3次钱，每次存3000
 */
class Account {
    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }
    public synchronized void deposit(int amt){
        if (amt > 0) {
            balance+=amt;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName()+"存钱成功，余额为"+balance);
        }
    }
}

class Customer extends Thread{
    private Account account;
    public Customer(Account account) {
        this.account=account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            account.deposit(1000);
        }
    }
}

public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account(0);
        Customer customer = new Customer(account);
        Customer customer1 = new Customer(account);
        customer.start();
        customer1.start();
    }
}
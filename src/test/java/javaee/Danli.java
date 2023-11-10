package javaee;

//单列设计模式举例
//类中只能有一个对象，在外部不能创建多个对象
public class Danli {
    public static void main(String[] args) {
//        javaee.bank javaee.bank = new javaee.bank();
        bank a = bank.getbank();
        a.eat();
        oner b = oner.getbank();
        b.eat();
    }
}

//饿汉式
class bank {
    //  将构造方法私有化，使得外部不能创建对象
    private bank() {}

    //    静态方法中只能调用静态成员变量
    private static bank b = new bank();

    //********************************
    //静态代码块，随着类的加载而执行，初始化类的信息
    //在当前代码中类初始化时对象就创建了，并在静态代码块之前
    static {
        System.out.println("静态代码块");
    }

    //代码块随着对象的创建而执行，有几个对象就执行几次，初始化对象信息
    {
        System.out.println("普通代码块");
    }


    //    public javaee.bank getbank(){
//        return b;
//    }
//    因为不能通过在外部创建对象来调方法所以创建一个静态方法，通过类来调用静态方法
    public static bank getbank() {
        return b;
    }

    public void eat() {
        System.out.println("饿汉式");
    }
}

//懒汉式
class oner {
    //  将构造方法私有化，使得外部不能创建对象
    private oner() {
    }

    //    静态方法中只能调用静态成员变量
    private static oner a = null;

    //    因为不能通过在外部创建对象来调方法所以创建一个静态方法，通过类来调用静态方法
    public static oner getbank() {
        if (a == null) {
            a = new oner();
        }
        return a;
    }

    public void eat() {
        System.out.println("懒汉式");
    }
}
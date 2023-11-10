package javaee;

public class InnerClass {
    public static void main(String[] args) {
        Animal.Dog d = new Animal.Dog();
        d.show();
        Animal a = new Animal();
        Animal.Bird b = a.new Bird();
        b.sing();
        b.display("方法形参name");

    }
}

class Animal {
    String name = "外部类name";
    int age;

    public void eat() {
        System.out.println("吃东西");
    }

    //  静态成员内部类
    static class Dog {
        String name = "静态成员内部类name";
        int age;

        public void show() {
            System.out.println("看电影");
            System.out.println(name);
//            eat();静态不能调非静态，静态先加载，非静态还未加载
        }

    }

    //  非静态成员内部类
    class Bird {
        String name = "非静态成员内部类name";

        public Bird() {

        }

        public void sing() {
            System.out.println("唱歌");
            Animal.this.eat();//相当于eat();
            System.out.println(age);
        }

        public void display(String name) {
            System.out.println(name);
            System.out.println(this.name);
            System.out.println(Animal.this.name);
        }

    }

    //方法
    public void method() {
        //局部内部类
        class AA {

        }
    }

    //代码块
    {
        //局部内部类
        class BB {
        }
    }

    //构造器
    public Animal() {
        //局部内部类
        class CC {

        }
    }
}

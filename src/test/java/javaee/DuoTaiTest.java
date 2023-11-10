package javaee;

import java.util.Objects;
import java.util.Scanner;

public class DuoTaiTest {
    public static void main(String[] args) {
        DuoTaiTest duoTaiTest = new DuoTaiTest();
        duoTaiTest.method(new javaee.Women());
        duoTaiTest.panduan(new Women());
        Person person = new Person();
        Person person1 = new Person();
        boolean a = person.equals(person1);
//        boolean a = person == person1;
//        String c = "10";
//        String d = "10";
//        boolean b = c==d;
        System.out.println(a);
    }


    public void method(Person person) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入年龄：");
        int age = scanner.nextInt();
        System.out.println("请输入名字：");
        String name = scanner.next();
        person.setAge(age);
        person.setName(name);
        String a = person.getName() + person.getAge() + "岁" + person.eat();
        System.out.println(a);
    }

    public void panduan(Person person) {
        if (person instanceof Man) {
//          向下转型
            Man m = (Man)person;
            m.show();
            System.out.println("男人");
        } else if (person instanceof Women) {
//          向下转型
            Women w = (Women)person;
            w.show();
            System.out.println("女人");
        } else {
            System.out.println("人");
        }
    }
}

class Person {
    private String name = "人";
    private int age = 0;

    public Person() {
        this.name = name;
        this.age = age;
    }

    //重写equals方法
    @Override
    public boolean equals(Object o) {
//      传入的是引用数据类型这里比较的是地址值
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getAge() == person.getAge() && Objects.equals(getName(), person.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

        public void setAge(int age) {
        this.age = age;
    }

    public String eat() {
//        System.out.println();
        return "得吃饭";
    }
}

class Man extends Person {
    String Job = "要工作";

    @Override
    public String eat() {
        super.eat();
        show();
        return "得吃有营养的";
    }

    public void show() {
        System.out.println(Job);
    }
}

class Women extends Person {
    String weight = "要减肥";

    @Override
    public String eat() {
        super.eat();
        show();
        return "得吃健康的";
    }

    public void show() {
        System.out.println(weight);
    }
}
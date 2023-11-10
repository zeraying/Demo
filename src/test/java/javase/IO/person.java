package javase.IO;

import java.io.Serializable;

public class person implements Serializable {
    //    在自定义异常时也需要声明序列版本号
    //    该版本号不能与原来的一致
    public static final long serialVersionUID = 4562367373567L;
    private String name;
    private int age;

    public person() {
    }

    public person(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

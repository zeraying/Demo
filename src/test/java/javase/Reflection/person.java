package javase.Reflection;

/**
 * @author pzy
 * @create 2023-09-25-19:59
 * @function
 */
public class person {
    private String name;
    public int age;

    public person() {
        System.out.println("person()");
    }

    private person(String name) {
        this.name = name;
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

    public void show() {
        System.out.println("公共方法");
    }

    private String show1(String agrs) {
        System.out.println("私有方法" + agrs);
        return agrs;
    }
}

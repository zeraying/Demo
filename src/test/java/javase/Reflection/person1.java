package javase.Reflection;

/**
 * @author pzy
 * @create 2023-09-26-17:10
 * @function
 */
@MyAnnotation(value = "hi")
public class person1 extends Creature<String> implements Comparable<String>, MyIterface {
    private String name;
    public int age;
    int id;

    public person1() {
    }

    @MyAnnotation(value = "abc")
    private person1(String name) {
        this.name = name;
    }

    @MyAnnotation
    person1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @MyAnnotation
    private String show(String nation) {
        System.out.println("我的国籍是" + nation);
        return nation;
    }

    public String display(String interests) {
        return interests;
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }

    @Override
    public void info() {
        System.out.println("我是一个人");
    }
    private static void showDesc(){
        System.out.println("我是一个可爱的人");
    }
}

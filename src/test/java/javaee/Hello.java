package javaee;

public class Hello {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("请输入你的名字:");
//        String a = scanner.next();
//        System.out.println("a = " + a);
//        if (a != "hello"){
//            System.out.println("yes");
//        }


        int c = (int) (Math.random() * 10);
////        Math.random()是令系统随机选取大于等于 0.0 且小于 1.0 的伪随机 double 值
        System.out.println(c);

        int a = (int) java.lang.Math.sqrt(77);
//      开平方
        System.out.println(a);
    }
}

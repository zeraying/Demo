package javaee;

public class InnerClassTest {
    //方法
    public void method() {
        //局部内部类
        class AA {

        }
    }

    //返回一个实现了Comparable接口的类的对象
    public Comparable getComparable() {
        //创建一个实现了Comparable接口的类
        //方式一
        class myComparable implements Comparable {

            @Override
            public int compareTo(Object o) {
                return 0;
            }
        }
        //返回的是一个类的对象
        return new myComparable();
        //方式二
//        return new Comparable() {
//            @Override
//            public int compareTo(Object o) {
//                return 0;
//            }
//        };
    }
}

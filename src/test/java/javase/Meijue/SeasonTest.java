package javase.Meijue;

/**
 * @author pzy
 * @create 2023-09-09-20:40
 * @function 枚举类的定义
 *              1.自定义枚举类
 *              2.使用enum关键字定义枚举类
 * enum类中的常用方法
 *    1.toString
 *    2.values
 *    3.State
 */
public class SeasonTest {
    public static void main(String[] args) {
        season1 chun = season1.chun;
        System.out.println(chun.toString());
//        Season.values()方法会返回包括所有枚举变量的数据。
//        默认情况下，枚举会给所有的枚举变量提供一个默认的次序，从0开始，Season.ordinal()可以获取其次序。
        season1[] values = season1.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }
//        此方法的作用是传来一个字符串，然后将它转换成对应的枚举变量。前提是传入的字符串和定义枚举变量的字符串一模一样，须区分大小写。
        season1 dong = season1.valueOf("dong");
        System.out.println(dong);
//        System.out.println(season1.class.getSuperclass());
        dong.show();
    }
}

//自定义枚举类
class season {
    //   1.声明对象的属性，用private final修饰
    private final String seasonName;
    private final String seasonDesc;

    //   2.私有化类的构造器，并给对象赋值
    private season(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    //    3.提供当前枚举类的多个对象，用public static final 修饰
    public static final season chun = new season("春天", "春暖花开");
    public static final season xia = new season("夏天", "夏日炎炎");
    public static final season qiu = new season("秋天", "秋高气爽");
    public static final season dong = new season("冬天", "冰天雪地");

    //    4.提供其他需要的方法
    @Override
    public String toString() {
        return "season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}
interface Show {
    public abstract void show();
}
//使用enum关键字定义枚举类
//使用enum关键字定义枚举类实现接口有两种方法
//    1.直接重写抽象方法
//    2.对每个对象重写抽象方法
enum season1 implements Show{
//    1.提供当前枚举类的多个对象，多个对象之间用，隔开
     chun("春天", "春暖花开"){
    @Override
    public void show() {
        System.out.println("春天的歌");
    }
},
    xia("夏天", "夏日炎炎"){
        @Override
        public void show() {
            System.out.println("夏天的歌");
        }
    },
    qiu("秋天", "秋高气爽"){
        @Override
        public void show() {
            System.out.println("秋天的歌");
        }
    },
     dong("冬天", "冰天雪地"){
         @Override
         public void show() {
             System.out.println("冬天的歌");
         }
     };
//   2.声明对象的属性，用private final修饰
    private final String seasonName;
    private final String seasonDesc;

//   3.私有化类的构造器，并给对象赋值
    private season1(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

//    @Override
//    public void show() {
//        System.out.println("季节的歌");
//    }

//    public String getSeasonName() {
//        return seasonName;
//    }
//
//    public String getSeasonDesc() {
//        return seasonDesc;
//    }
//    4.提供其他需要的方法
//    @Override
//    public String toString() {
//        return "season{" +
//                "seasonName='" + seasonName + '\'' +
//                ", seasonDesc='" + seasonDesc + '\'' +
//                '}';
//    }
}
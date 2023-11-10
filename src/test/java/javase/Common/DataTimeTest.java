package javase.Common;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Calendar;
import java.util.Date;

/**
 * @author pzy
 * @create 2023-09-07-15:53
 * @function jdk8之前的日期时间api的测试
 *              1.System类中currenTimeMillis();
 *              2.java.util.Date和子类java.sql.Date
 *              3.SimpleDateFormat
 *              4.Calendar
 */
public class DataTimeTest {
    public static void main(String[] args) {
//        返回当前时间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差
        System.out.println(System.currentTimeMillis());
    }

    @Test
    public void test1() {
//        java.util.Date
//        构造器一：创建对应当前时间的date对象
        Date date = new Date();
        System.out.println(date.toString());//Thu Sep 07 19:41:13 CST 2023
        System.out.println(date.getTime());//1694087281530
//        构造器二：创建对应指定毫秒数的date对象
        Date date1 = new Date(169408728153L);
        System.out.println(date1.toString());
//        java.sql.Date
        java.sql.Date date2 = new java.sql.Date(16940872815L);//1970-07-16
        System.out.println(date2.toString());
    }
    @Test
    public void test2() {
//        将java.util.Data对象转换为java.sql.Data对象
        Date date = new Date();
        java.sql.Date date1 = new java.sql.Date(date.getTime());
        System.out.println(date1);//2023-09-08
    }
    @Test
//    SimpleDateFormat对日期和Date类的格式化和解析
//    1.格式化:日期-->字符串
//    2.解析:字符串-->日期
    public void test3() throws ParseException {
//       格式化：使用默认构造器
        SimpleDateFormat sdf = new SimpleDateFormat();
//        格式化
        Date date = new Date();
        String format = sdf.format(date);
        System.out.println(format);
//        解析
        String str = "23-9-8 下午9:05";
        Date date1 = sdf.parse(str);
        System.out.println(date1);
//       格式化：使用指定格式构造器
        SimpleDateFormat sdf1 = new SimpleDateFormat("yy-MM-dd hh:mm:ss");
        System.out.println(sdf1.format(date));
//        字符串需符合SimpleDateFormat识别的格式
        Date date2 = sdf1.parse("23-09-04 09:12:26");
        System.out.println(date2);
    }
    @Test
//    Calendar日历类(抽象类)的使用
    public void testCalendar(){
//       实例化
//        1.创建其子类(GregorianCalendar)的对象
//        2.调用其静态方法getInstance()
        Calendar instance = Calendar.getInstance();
//        System.out.println(instance.getClass());
        //get
        System.out.println(instance.get(Calendar.DAY_OF_MONTH));
        System.out.println(instance.get(Calendar.DAY_OF_YEAR));
        //set
        instance.set(Calendar.DAY_OF_MONTH,11);
        System.out.println(instance.get(Calendar.DAY_OF_MONTH));
        instance.set(Calendar.DAY_OF_YEAR,321);
        System.out.println(instance.get(Calendar.DAY_OF_YEAR));
        //add
        instance.add(Calendar.DAY_OF_MONTH,-3);
        System.out.println(instance.get(Calendar.DAY_OF_YEAR));
        //getTime
        Date date = instance.getTime();
        System.out.println(date);
        // setTime
        Date date1 =new Date();
        instance.setTime(date1);
        System.out.println(instance.getTime());
    }
    @Test
//    LocalDate,LocalTime,LocalDateTime的使用
    public void test4(){
        //now()获取当前时间
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);
        //of()设置指定的时间
        LocalDateTime localDateTime1 = LocalDateTime.of(2023, 9, 8,22,15,3);
        System.out.println(localDateTime1);

        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getMonthValue());
    }
    @Test
//    瞬时Instant
    public void test5(){
//        now()获取子午线对应的时间
        Instant instant = Instant.now();
        System.out.println(instant);
//        添加时间的偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);
//        获取自1970年1月1日的毫秒数
        System.out.println(instant.toEpochMilli());
//        通过毫秒数获取Instant实例
        System.out.println(Instant.ofEpochMilli(155548574857L));
    }
}


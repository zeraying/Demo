package javase.Collection;

import org.junit.Test;

import java.util.*;

/**
 * @author pzy
 * @create 2023-09-15-21:28
 * @function Collections常用工具类中的常用方法
 * Collections常用工具类能操作Collection和Map
 */
public class CollectionsTest {
    @Test
    /**
     * 对List进行操作
     * reverse(List) 反转
     * shuffle(List) 打乱顺序
     * sort(List) 升序排序
     * sort(List,Comparato) 自定义排序
     * swap(List,int,int) 交换指定索引的元素
     * frequency(Collection, Object)集合中指定元素出现的次数
     * copy(list deft,list src)将src中的内容复制到dest中
     * replaceAll(list,old,new)将集合中的旧值替换为新值
     */
    public void test1() {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(132);
        list.add(-454);
        list.add(32);
        list.add(763);
        list.add(234);
        list.add(21);
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        Collections.sort(list, new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Integer && o2 instanceof Integer) {
                    Integer integer = (Integer) o1;
                    Integer integer1 = (Integer) o2;
                    return -(integer-integer1);
                }
                throw new RuntimeException("数据类型不一致");
            }
        });
        System.out.println(list);
        int b = list.size();
        Collections.swap(list,0,b-1);
        System.out.println(list);
        System.out.println(Collections.frequency(list, 763));
//        复制的集合大小不能小于原集合
        List list1 = Arrays.asList(new Object[list.size()]);
        Collections.copy(list1,list);
        System.out.println(list1);
    }
    public void test2() {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(132);
        list.add(-454);
        list.add(32);
        list.add(763);
        list.add(234);
        list.add(21);
//        将集合变成了一个线程安全的集合
        List list1 = Collections.synchronizedList(list);


    }
}

package javase.Reflection;

import java.io.Serializable;

/**
 * @author pzy
 * @create 2023-09-26-17:03
 * @function
 */
public class Creature<T> implements Serializable {
    private char gender;
    public double weight;
    private void breath(){
        System.out.println("生物呼吸");
    }
    public void eat(){
        System.out.println("生物吃东西");
    }
}

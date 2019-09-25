package com.huyi.jvm;

/**
 * 当一个接口在初始化时，并不要求其父接口都完成了初始化
 *  只有在真正使用到父接口的时候（如引用接口中定义的常量），才会初始化
 *   接口里面的变量 默认 final 修饰的
 */
public class Jvm04 {
    public static void main(String[] args) {
        System.out.println(MyChild5.a);
    }
}
interface  MyParent5{
    public static  int a=5;

}
interface  MyChild5  extends  MyParent5{
    public static  int b=6;

}

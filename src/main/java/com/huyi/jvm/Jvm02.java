package com.huyi.jvm;

import java.util.UUID;


/**
 *  当一个常量的值并非编译期间可以确定的，那么其值就不会放到调用类的常量池中
 *  这时在程序运行时，会导致主动使用这个常量所在的类，显然会导致这个类被初始化
 */
public class Jvm02 {
    public static void main(String[] args) {
        System.out.println(MyParent.str);
    }
}

class  MyParent{

    public  static  final  String  str= UUID.randomUUID().toString();

    static {
        System.out.println("Myparent");
    }

}

package com.huyi.jvm;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class Jvm15 {
    public static void main(String[] args){
        //bootstrap class loader  启动类加载器


        //启动类 或者根类加载器
        String[] strings=new String[2];
        System.out.println(strings.getClass());
        System.out.println(strings.getClass().getClassLoader());    //输出null
        //
        Jvm15[] mytest15=new Jvm15[2];
        System.out.println(mytest15.getClass().getClassLoader());   //输出应用类加载器
        //原生数据类型 没有classLoader 加载器
        int[] arr=new int[2];
        System.out.println(arr.getClass().getClassLoader());        //输出null，此null非彼null
    }

}




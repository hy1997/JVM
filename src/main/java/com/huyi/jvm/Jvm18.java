package com.huyi.jvm;

//扩展类加载器只加载jar包，需要把class文件打成jar
public class Jvm18 {

    static {
        System.out.println("Jvm18  initializer");
    }

    public static void main(String[] args) {
        System.out.println(Jvm18.class.getClassLoader());
        System.out.println(Jvm01.class.getClassLoader());
    }
}

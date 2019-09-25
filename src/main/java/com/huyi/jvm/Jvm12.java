package com.huyi.jvm;

//调用ClassLoader类的loadClass方法加载一个类，并不是对类的的主动使用，不会导致类的初始化
//放射事主动调用
public class Jvm12 {

    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        Class<?> aClass = systemClassLoader.loadClass("com.huyi.jvm.Cl");
        System.out.println(aClass);
        System.out.println("-------");
        Class<?> aClass1 = Class.forName("com.huyi.jvm.Cl");//放射对类的主动使用
        System.out.println(aClass1);
    }
}

class Cl {
    static {
        System.out.println("Class  CL");
    }
}




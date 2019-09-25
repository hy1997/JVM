package com.huyi.jvm;

//调用ClassLoader类的loadClass方法加载一个类，并不是对类的的主动使用，不会导致类的初始化
//放射事主动调用
public class Jvm13 {
    /**
     * sun.misc.Launcher$AppClassLoader@659e0bfd
     * sun.misc.Launcher$ExtClassLoader@6d06d69c
     * null  有些实现会使用 null 来代表启动类加载器
     */
    public static void main(String[] args) throws ClassNotFoundException {
        //获取到系统类加载器
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        System.out.println(classLoader);//sun.misc.Launcher$AppClassLoader@659e0bfd
       while (classLoader!=null){
           //获取到父加载器
           classLoader=classLoader.getParent();
           System.out.println(classLoader);
       }
    }

}




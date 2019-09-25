package com.huyi.jvm;


import sun.misc.Launcher;

/*
    在运行期，一个Java类是由该类的完全限定名（binary name）和用于加载该类的定义类加载器所共同决定的。
    如果同样名字（完全相同限定名）是由两个不同的加载器所加载，那么这些类就是不同的，即便.class文件字节码相同，并且从相同的位置加载亦如此。

    在oracle的hotspot，系统属性sun.boot.class.path如果修改错了，则运行会出错：
    Error occurred during initialization of VM
    java/lang/NoClassDeFoundError: java/lang/Object
*/
public class Jvm19 {

    public static void main(String[] args){
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.calss.path"));

        System.out.println(ClassLoader.class.getClassLoader());
        System.out.println(Launcher.class.getClassLoader());

        //下面的系统属性指定系统类加载器，默认是AppClassLoader
        System.out.println(System.getProperty("java.system.class.loader"));
    }

}

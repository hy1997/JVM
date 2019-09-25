package com.huyi.classLoad.classLoadTest;

import java.io.*;

/**
 创建自定义加载器，继承ClassLoader
 */
public class MyTest16 extends ClassLoader{
    private String classLoaderName;
    private String path;
    private final String fileExtension=".class";

    public MyTest16(String classLoaderName){
        super();        //将系统类当做该类的父加载器
        this.classLoaderName=classLoaderName;
    }
    public MyTest16(ClassLoader parent,String classLoaderName){
        super(parent);      //显式指定该类的父加载器
        this.classLoaderName=classLoaderName;
    }

    public MyTest16(ClassLoader parent){
        super(parent);      //显式指定该类的父加载器
    }

    public void setPath(String path){
        this.path=path;
    }
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        System.out.println("calssName="+name);
        name=name.replace(".", File.separator);
        byte[] data= new byte[0];
        try {
            data = loadClassData(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return defineClass(name,data,0,data.length); //define方法为父类方法
    }

    private byte[] loadClassData(String name) throws IOException {
        InputStream is=null;
        byte[] data=null;
        ByteArrayOutputStream baos=null;
        try{
            is=new FileInputStream(new File(this.path+name+this.fileExtension));
            baos=new ByteArrayOutputStream();
            int ch;
            while(-1!=(ch=is.read())){
                baos.write(ch);
            }
            data=baos.toByteArray();

        }catch(Exception e){
        }finally{
            is.close();
            baos.close();
            return data;
        }
    }
    public static void test(ClassLoader classLoader) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> clazz=classLoader.loadClass("com.huyi.demo.controller.CommController");
        //loadClass是父类方法，在方法内部调用findClass
        System.out.println(clazz.hashCode());
        Object  object=clazz.newInstance();
        System.out.println(object);
    }
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        //父亲是系统类加载器，根据父类委托机制，MyTest1由系统类加载器加载了

        MyTest16 loader1=new MyTest16("loader1");
        loader1.path="C:\\Users\\HY\\Desktop\\";
        System.out.println(loader1.getParent());
        test(loader1);

//        //仍然是系统类加载器进行加载的，因为路径正好是classpath
     /*   MyTest16 loader2=new MyTest16("loader2");
        loader2.path="D:\\Eclipse\\workspace\\HiATMP-DDMS\\target\\classes\\";
        test(loader2);*/
//
//        //自定义的类加载器被执行，findClass方法下的输出被打印。前提是当前calsspath下不存在MyTest1.class，MyTest16的父加载器-系统类加载器会尝试从classpath中寻找MyTest1。
//        MyTest16 loader3=new MyTest16("loader3");
//        loader3.path="C:\Users\weichengjie\Desktop\";
//        test(loader3);
//
//        //与3同时存在，输出两个class的hash不一致，findClass方法下的输出均被打印，原因是类加载器的命名空间问题。
//        MyTest16 loader4=new MyTest16("loader4");
//        loader4.path="C:\Users\weichengjie\Desktop\";
//        test(loader4);
//
//        //将loader3作为父加载器
//        MyTest16 loader5=new MyTest16(loader3,"loader3");
//        loader3.path="C:\Users\weichengjie\Desktop\";
//        test(loader5);
    }
}

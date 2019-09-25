package com.huyi.jvm;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class Jvm14 {
    public static void main(String[] args) throws IOException {
        ClassLoader loader=Thread.currentThread().getContextClassLoader();
        System.out.println(loader);         //输出AppClassLoader
        //下面这段没整明白什么用，先记录下来
        String resourceName="com/huyi/jvm/jvm13.class";
        Enumeration<URL> urls=loader.getResources(resourceName);
        while(urls.hasMoreElements()){
            URL url=urls.nextElement();
            //file:/C:/Users/HY/IdeaProjects/JVM/build/classes/java/main/com/huyi/jvm/jvm13.class
            System.out.println(url);
        }
        //不同的类有不同的加载器
        Class<Jvm14> jvm14Class = Jvm14.class;
        System.out.println(jvm14Class.getClassLoader());
        System.out.println("-----------");
        Class<String> StringClass = String.class;
        System.out.println(StringClass.getClassLoader());

    }

}




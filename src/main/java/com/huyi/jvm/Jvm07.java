package com.huyi.jvm;

public class Jvm07 {
    /**
     * java.lang.String是由根加载器加载，在rt.jar包下
     */
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> clazz = Class.forName("java.lang.String");
        //启动类加载器 返回null
        System.out.println(clazz.getClassLoader());  //返回null

        Class<?> clazz2 = Class.forName("com.huyi.jvm.C");
        System.out.println(clazz2.getClassLoader());  //输出sun.misc.Launcher$AppClassLoader@18b4aac2  其中AppClassLoader:系统应用类加载器
    }



}
class C {

}

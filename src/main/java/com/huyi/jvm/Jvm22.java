package com.huyi.jvm;

/*
线程上下文类加载器的一般使用模式(获取-使用-还原)
ClassIoader classLoader = Thread. currentThread( ) .getContextClassLoader();
try {
        Thread . currentThread() .setContextClassLoader (targetTccl);
        myMethod();
    } finally {
        Thread . currentThread( ). setContextClassLoader (classLoader);
    }
myMethod里面则调用了Thread . currentThread(). getContextClassLoader(),获取当前线程的上下文类加载器做某些事情。
如果一个类由类加载器A加载，那么这个类的依赖类也是由相同的类加载器加载的(如果该依赖类之前没有被加载过的话)
ContextClassLoader的作用就是为了破坏Java的类加载委托机制。

当高层提供了统- -的接口让低层去实现，同时又要在高层加载(或实例化)低层的类时，就必须要通过线程上下文类加载器来帮助高层的ClassLoader
.找到并加载该类。
*/

import java.sql.Driver;
import java.util.Iterator;
import java.util.ServiceLoader;

public class Jvm22 {

    public static void main(String[] args) {

        //一旦加入下面此行，将使用ExtClassLoader去加载Driver.class， ExtClassLoader不会去加载classpath，因此无法找到MySql的相关驱动。
        //Thread.getCurrentThread().setContextClassLoader(MyTest26.class.getClassLoader().parent());

        ServiceLoader<Driver> loader=ServiceLoader.load(Driver.class);
        Iterator<Driver> iterator=loader.iterator();
        while(iterator.hasNext()){
            Driver driver=iterator.next();
            System.out.println("driver:"+Driver.class+ ",loader"+Driver.class.getClassLoader());
        }
        System.out.println("当前上下文加载器" +Thread.currentThread().getContextClassLoader());
        System.out.println("ServiceLoader的加载器" +ServiceLoader.class.getClassLoader());
    }
}

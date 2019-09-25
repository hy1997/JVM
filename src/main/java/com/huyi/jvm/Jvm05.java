package com.huyi.jvm;

public class Jvm05 {
        public static void main(String[] args){
            Singleton Singleton= com.huyi.jvm.Singleton.getInstance();
            System.out.println(Singleton.counter1);     //输出1，1
            System.out.println(Singleton.counter2);
    }
}

class Singleton {
    public static int counter1;
    public static int counter2 = 0;
    private static Singleton singleton = new Singleton();

    private Singleton() {
        counter1++;
        counter2++;
    }
    // public static int counter2=0;       //   若改变此赋值语句的位置，输出  1，0
    public static Singleton getInstance(){
        return singleton;
    }
}

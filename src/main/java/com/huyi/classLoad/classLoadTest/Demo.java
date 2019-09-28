package com.huyi.classLoad.classLoadTest;

public class Demo {



    public static void main(String[] args) {
        String a = Demo1.A;
        String c ="";
        System.out.println(a=a+new Demo1().b);
        System.out.println(a);
    }
}


class Demo1{
    public  static   String  A="huyi";
    String  b ="aaaa";


    static {
        System.out.println("static  init ");

    }
        }

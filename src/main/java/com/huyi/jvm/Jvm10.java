package com.huyi.jvm;

public class Jvm10 {

    static {
        System.out.println("Jvm09  block");
    }

    public static void main(String[] args) {

        System.out.println(Child2.b);
    }
}

class Parent2 {
    static int a = 3;

    static {
        System.out.println("Parent2  static  block");

    }
}

class Child2 extends  Parent1{
    static int b = 4;

    static {
        System.out.println("Child2 static  block");
    }

}



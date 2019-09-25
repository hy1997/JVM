package com.huyi.jvm;

public class Jvm09 {

    static {
        System.out.println("Jvm09  block");
    }

    public static void main(String[] args) {
        System.out.println(Child1.b);
    }
}

class Parent1 {
    static int a = 3;

    static {
        System.out.println("Parent  static  block");

    }
}

class Child1 extends  Parent1{
    static int b = 4;

    static {
        System.out.println("Child static  block");
    }

}



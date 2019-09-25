package com.huyi.jvm;

public class Jvm11 {

    public static void main(String[] args) {

        System.out.println(Child3.a);
        System.out.println("-------");
        Parent3.doSomething();

    }
}

class Parent3 {
    static int a = 3;

    static {
        System.out.println("Parent2  static  block");
    }

    static void doSomething() {
        System.out.println("do Something");
    }
}

class Child3 extends Parent3 {

    static {
        System.out.println("Child2 static  block");
    }

}



package com.huyi.jvm;

import java.util.Random;

public class Jvm08 {

    public static void main(String[] args) {
        System.out.println(FinalTest.x);
    }


}
class  FinalTest{

    public  static  final  int x= new Random().nextInt(3);
    static {

        System.out.println("Final static  block");
    }
}

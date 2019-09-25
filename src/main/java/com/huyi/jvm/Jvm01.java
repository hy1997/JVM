package com.huyi.jvm;

/**
 * 常量在编译阶段会存入到调用这个常量的方法所在的类的常量池中
 *         本质上，调用类并没有直接调用到定义常量的类，因此并不会触发定义常量的类的初始化
 *         注意：这里指的是将常量存到MyTest2的常量池中，之后MyTest2和MyParent就没有任何关系了。
 *         甚至我们可以将MyParent2的class文件删除

 *         助记符 ldc：表示将int、float或者String类型的常量值从常量池中推送至栈顶
 *         助记符 bipush：表示将单字节（-128-127）的常量值推送到栈顶
 *         助记符 sipush：表示将一个短整型值（-32768-32369）推送至栈顶
 *         助记符 iconst_1：表示将int型的1推送至栈顶（iconst_m1到iconst_5）
 */
    public class Jvm01{
        public static void main(String[] args){
            System.out.println(MyParent2.str);    //输出 hello world
            System.out.println(MyParent2.s);
            System.out.println(MyParent2.i);
            System.out.println(MyParent2.j);
        }
    }
    class MyParent2{

        public static final String str="hello world";

        public static final short s=7;
        public static final int i=129;
        public static final int j=1;

        static {
            System.out.println("MyParent static block");
        }

}

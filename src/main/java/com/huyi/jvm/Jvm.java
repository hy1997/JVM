package com.huyi.jvm;


/**
  对于静态字段来说，只有只有直接定义该字段的类才会被初始化
  但一个类在初始化时，要求其父类全部初始化完毕
  -XX:+TraceClassLoading，用户追踪类的加载信息并的打印出来
  -XX:+<option>，表示开启option选项
  -XX:-<option>，表示关闭option选项
  -XX:<option>=value，表示将option的值设置为value
 */
public class Jvm {

    public static void main(String[] args) {
        System.out.println(Child.str);
    }

}

class  Parent{
    public  static   String  str="hello  word ";

    static {
        System.out.println("Parent");
    }
}
class  Child extends Parent{

    static {
        System.out.println("Child");
    }


}

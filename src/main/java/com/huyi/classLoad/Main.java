package com.huyi.classLoad;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) {
        String url = "C:\\Users\\HY\\Desktop\\CommController.class";
        MyClassLoader myClassLoader = new MyClassLoader(url);
        try {
            Class<?> aClass = myClassLoader.loadClass("load");
            Object o = aClass.newInstance();
            Field[] declaredFields = aClass.getDeclaredFields();
            for (Field declaredField : declaredFields) {
                declaredField.setAccessible(true);
                Object o1 = declaredField.get(o);
                System.out.println(o1);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}

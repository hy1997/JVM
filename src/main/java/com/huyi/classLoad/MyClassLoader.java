package com.huyi.classLoad;

import java.io.*;
import java.net.URL;

public class MyClassLoader extends ClassLoader {

    private String url;

    public MyClassLoader(String url) {
        super(); //将系统类当做该类的父加载器
        this.url = url;
    }

    public MyClassLoader(ClassLoader parent, String url) {
        super(parent);//显式指定该类的父加载器
        this.url = url;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        System.out.println("name ：" +name);
        byte[] classData = new byte[0];
        try {
            classData = loadClassData(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return defineClass(name, classData, 0, classData.length);
    }

    private byte[] loadClassData(String name) throws ClassNotFoundException, IOException {
        String uri = url + name;
        System.out.println("url :" +uri);
        return loadDataFromUrl(url);
    }

    private byte[] loadDataFromUrl(String uri) throws ClassNotFoundException, IOException {
        FileInputStream inputStream =null;
        byte[] classData=null;
        try {
            inputStream = new FileInputStream( new File(uri));
            byte[] b = new byte[1024];
            int len;
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            while ((len = inputStream.read(b)) != -1) {
                bos.write(b, 0, len);
            }
             classData = bos.toByteArray();

        } catch (Exception ex) {
            throw new ClassNotFoundException();
        }finally {
            if(inputStream!=null) {
                   inputStream.close();
            }
        }
        return classData;
    }
}

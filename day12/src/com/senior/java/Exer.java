package com.senior.java;

import com.senior.java1.Person;
import org.junit.Test;

import javax.naming.Name;
import javax.print.DocFlavor;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.channels.FileLockInterruptionException;
import java.util.Properties;

/**
 * @author JUNSHI 405773808@qq.com
 * @create 2020-03-20 10:08
 */

interface Human1 {

    String getBelief1();

    void eat1(String food);

}

//被代理
class SuperMan1 implements Human1 {

    @Override
    public String getBelief1() {
        return "I believe I can fly!";
    }

    @Override
    public void eat1(String food) {
        System.out.println("我喜欢吃" + food);
    }

}

class ProxyFactory1 {

    public static Object getProxyInstance1(Object obj) {//obj被代理类对象

        MyInvocationHandler1 handler1 = new MyInvocationHandler1();

        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler1);


    }

}

class MyInvocationHandler1 implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}

//动态代理类


public class Exer {

    @Test
    public void test1() throws Exception {

        Class calzz = Person.class;
        Object o = calzz.newInstance();


        Field uid = calzz.getDeclaredField("UID");

        uid.setAccessible(true);
        uid.set(o,100);
        System.out.println(uid.get(o));



    }

    @Test
    public void test() {

        BufferedInputStream bfis = null;
        BufferedOutputStream bfos = null;
        try {
            FileInputStream fis = new FileInputStream(new File("JDBC.properties"));
            FileOutputStream fos = new FileOutputStream(new File("JDBC1.properties"));

            bfis = new BufferedInputStream(fis);
            bfos = new BufferedOutputStream(fos);

            byte[] bytes = new byte[10];
            int len;
            while ((len = bfis.read(bytes)) != -1){
                bfos.write(bytes,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bfis != null){

                try {
                    bfis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bfos != null){

                try {
                    bfos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }





    }

    @Test
    public void testProperties() throws Exception {

        Properties properties = new Properties();

        ClassLoader classLoader = Exer.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("JDBC.properties");

        properties.load(is);

        String user = properties.getProperty("User");
        String passward = properties.getProperty("passward");

        System.out.println("user = " + user + ",passward = " + passward);

    }

//
//    @Test
//    public void test() throws Exception {
//
//        Class clazz1 = Person.class;
//
//        Person p = (Person) clazz1.newInstance();
//
//        Method show = clazz1.getDeclaredMethod("show");
//
//        show.setAccessible(true);
//
//        show.invoke(p);
//
//
//    }


}

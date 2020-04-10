package com.senior.java;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Properties;


/**
 * @author JUNSHI 405773808@qq.com
 * @create 2020-03-19 18:27
 */
public class Exer {

    @Test
    public void test5() throws IllegalAccessException, InstantiationException {

        Class c = Person.class;

        Person o = (Person) c.newInstance();



    }



    @Test
    public void test4() throws Exception {

        Properties properties = new Properties();
//        FileInputStream fis = new FileInputStream("jdbc.properties");
//        properties.load(fis);

        ClassLoader classLoader = Exer.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc1.properties");
        properties.load(is);

        String name = properties.getProperty("name");
        String passward = properties.getProperty("passward");

        System.out.println("name = " + name + ",passward = " + passward);


    }

    //反射之前对于Person类的操作
    @Test
    public void test(){

        Person p1 = new Person("Tom",12);

        p1.age = 10;
        p1.show();

        System.out.println();

    }

    @Test
    public void test2() throws Exception {

        Class calzz = Person.class;
        Constructor cons = calzz.getConstructor(String.class, int.class);

        Object tom = cons.newInstance("Tom", 12);
        Person p = (Person)tom;
        System.out.println(p.toString());

        Field age = calzz.getDeclaredField("age");
        age.set(p,10);
        System.out.println(p.toString());

        Method show = calzz.getDeclaredMethod("show");
        show.invoke(p);

        System.out.println("**********************");
        Constructor cons1 = calzz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person p1 = (Person) cons1.newInstance("Jerry");
        System.out.println(p1);

        Field name = calzz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1,"HanMeimei");
        System.out.println(p1);

        Method showNation = calzz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation  = (String) showNation.invoke(p1, "中国");
        System.out.println(nation);


    }

    @Test
    public void test3() throws ClassNotFoundException {

        Class clazz1 = Person.class;

        Person p1 = new Person();
        Class clazz2 = p1.getClass();

        Class clazz3 = Class.forName("com.senior.java.Person");

        ClassLoader classLoader = Exer.class.getClassLoader();
        Class<?> aClass = classLoader.loadClass("com.senior.java.Person");


    }


}

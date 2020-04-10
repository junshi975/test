package com.senior.java2;

import com.senior.java1.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author JUNSHI 405773808@qq.com
 * @create 2020-03-19 22:51
 */
public class Exer {

    @Test
    public void test3() throws Exception {

        Class clazz = Person.class;

        Constructor constructor = clazz.getDeclaredConstructor(String.class);

        constructor.setAccessible(true);

        Person per = (Person) constructor.newInstance("Tom");
        System.out.println(per);


    }

    @Test
    public void test2() throws Exception {

        Class clazz = Person.class;

        Person p = (Person) clazz.newInstance();

        Method show = clazz.getDeclaredMethod("show", String.class);

        show.setAccessible(true);

        Object returnValue = show.invoke(p, "CHN");
        System.out.println(returnValue);

        System.out.println("***********");

        Method showDesc = clazz.getDeclaredMethod("showDesc");

        showDesc.setAccessible(true);
        Object returnVal = showDesc.invoke(Person.class);
        System.out.println(returnVal);


    }

    @Test
    public void test1() throws Exception {

        Class clazz = Person.class;

        Person p = (Person) clazz.newInstance();

        Field name = clazz.getDeclaredField("name");

        name.setAccessible(true);

        name.set(p,"Tom");

        System.out.println(name.get(p));






    }

    @Test
    public void test() throws Exception {

        Class clazz = Person.class;

        Person p = (Person) clazz.newInstance();

        Field id = clazz.getField("id");

        //set方法，参数1
        id.set(p,1001);

        int pId = (int) id.get(p);
        System.out.println(pId);

        Class clazz1 = Person.class;
        Object o = clazz1.newInstance();

    }





    @Test
    public void test4(){


        Exer e = new Exer();

        e.print(100);

    }

    public void print(int insertCount) {
        int i = 0;
        while (i < insertCount) {
            i++;
            if ( i % 2 != 0){
                continue;
            }
            System.out.println("小白" + i + ", 00000");

        }
    }
//    CREATE PROCEDURE test_while1(IN insertCount INT)
//    BEGIN
//    DECLARE i INT default 0;
//    a:while i <= insertCount Do
//    SET i = i + 1;
//	    if mod(i,2) != 0 THEN ITERATE a;
//    END if;
//    INSERT INTO admin(username,`password`) VALUES (concat('小虎',i),'0000');
//    END while a;
//    END;

    @Test
    public void testRand(){
//        random() [0.0,1.0)
        //若需要[0,26] 则 * 26 -> [0,26) -> (int)(roandom() * 26 + 1 )-> [0,26]
        int value = (int)(Math.random() * 26 + 1);

//        (int)(Math.random() * (b - a + 1)) + a [10,99]
        int value2 = (int)(Math.random() * (99 - 10 + 1)) + 10;


//                [a,b] [0,26]
       int value1 = (int)(Math.random() * (26 - 0 + 1)) + 0;


    }
}

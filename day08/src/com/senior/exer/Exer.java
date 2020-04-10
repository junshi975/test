package com.senior.exer;


import com.senior.java.Person;
import com.senior.java1.Student;
import org.junit.Test;

import java.time.Period;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author JUNSHI 405773808@qq.com
 * @description:
 * @create 2020-03-15 14:48
 */
public class Exer<T> {

    @Test
    public void test4(){

        //只能Person与Person的子类使用
        List<? extends Person1> list1 = null;//（Person子类，Person]

        //只能Person与Person的父类使用
        List<? super Person1> list2 = null;//[Person,person父类）

        List<Student1> list3 = new ArrayList<Student1>();
        List<Person1> list4 = new ArrayList<Person1>();
        List<Object> list5 = new ArrayList<Object>();

        list1 = list3;
        list1 = list4;
//        list1 = list5;//Object是Person的父类。超过了界限

//        list2 = list3;//小于了Person的界限，必须是Person本身与Person父类使用
        list2 = list4;
        list2 = list5;

        //读取数据
        list1 = list4;//此时list1的类型是Person
        //可以使用Person与Object接收 因为Person，Object可以接收Person和Student的值
        Person1 person1 = list1.get(0);
        //返回的类型可能是Person 因为Student < Person所以 不能用Student来接收Person的值
//        Student s = list1.get(0);

        list2 = list4;
        //返回的类型可能是Person或Object的值，所以只能使用Object接收
        Object obj = list2.get(0);
        //返回的类型可能有Object的值，Person接收不了Object的值
//        Person1 p = list2.get(0);//不能用Person接收 Person < Object

        //写入数据
        //编译错误，
//        <? extends Person> ?不确定，要是放入Student有可能?比Student小，
//        list1.add(new Student1());
//        list1.add(new Person1());
//        list1.add(new Object());
//        <? super Person> ?不确定，？最起码可以是Person，那比Person更小的都可以
        list2.add(new Student1());
        list2.add(new Person1());
//        list2.add(new Object());//因为[Person - Object)那么要是？是Objcet更不满足要求

    }



    @Test
    public void test3(){

        List<Object> list1 = null;
        List<String> list2 = null;

        List<?> list = null;
        list = list1;
        list = list2;

//        print(list1);
//        print(list2);

        ArrayList<String> list3 = new ArrayList<>();
        list3.add("SAA");
        list3.add("SAvA");
        list3.add("SA");
        list3.add("SAaA");

        list = list3;
        Object o = list.get(1);
        System.out.println(o);


    }
    public void print(List<?> list){

        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()){

            Object next = iterator.next();
            System.out.println(next);

        }

    }


    @Test
    public void test(){

        Exer2<String> e = new Exer2<>();

        Integer[] arr = new Integer[]{1,12,3};
        List<Integer> integers = e.copyFromArrayToList(arr);


    }

    @Test
    public void test1(){

        Exer1 e = new Exer1();
        e.setExerT(234);

        Exer2<String> e1 = new Exer2<>();
        e1.setExerT("dsf");

    }

    String name ;
    int age;
    T exerT;

    public void setExerT(T exerT){
        this.exerT = exerT;
    }
    public T getExerT(){
        return exerT;
    }

}

class Exer1 extends Exer<Integer>{



}

class Exer2<T> extends Exer<T>{

    public  <E>  List<E> copyFromArrayToList(E[] arr){

        ArrayList<E> list = new ArrayList<>();

        for(E e : arr){
            list.add(e);
        }
        return list;

    }
}

class Person1{

}

class Student1 extends Person1{

}
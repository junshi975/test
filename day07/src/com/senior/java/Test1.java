package com.senior.java;

import org.junit.Test;

import java.util.*;

/**
 * @author JUNSHI 405773808@qq.com
 * @description:
 * @create 2020-03-14 21:42
 */
public class Test1 {

    @Test
    public void test1(){
        ArrayList list = new ArrayList();
        list.add(223);
        list.add(23);
        list.add(-9);
        list.add(113);

        List dist = Arrays.asList(new Object[list.size()]);
        Collections.copy(dist,list);
        System.out.println(dist);

        Collection collection = Collections.synchronizedCollection(list);
        System.out.println(collection);

    }


    @Test
    public void test(){

        ArrayList list = new ArrayList();
        list.add(223);
        list.add(23);
        list.add(-9);
        list.add(113);
        list.add(113);
        list.add(113);
        list.add(113);
        list.add(12);

        System.out.println(list);
//        Collections.reverse(list);//反转list本身被改了

//        Collections.shuffle(list);//随机

//        Collections.sort(list);//自然排序从下到大

//        Collections.swap(list,0,1);
        Comparable max = Collections.max(list);
        System.out.println(max);
        int frequency = Collections.frequency(list, 113);
        System.out.println(frequency);
        System.out.println(list);


    }
}

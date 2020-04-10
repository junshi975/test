package com.senior.java1;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author JUNSHI 405773808@qq.com
 * @description:
 * @create 2020-03-23 18:28
 */
public class Exer {

//    var num = 18;
    @Test
    public void test(){

        var num = 19;

        var list = new ArrayList<Integer>();
        list.add(123);

        list.forEach(System.out::println);

        for (var i : list){
            System.out.println(i);

        }

    }

}

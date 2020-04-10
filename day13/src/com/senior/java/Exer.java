package com.senior.java;

import org.junit.Test;

import java.util.Optional;

/**
 * @author JUNSHI 405773808@qq.com
 * @description:
 * @create 2020-03-23 10:35
 */
public class Exer {

    @Test
    public void test(){

        Optional<Object> empty = Optional.empty();
        if (!empty.isPresent()){
            System.out.println("数据为空");
        }


    }

    @Test
    public void test1(){

        String str = "hello";
//        str = null;
        Optional<String> str1 = Optional.of(str);

        System.out.println(str1.get());

    }

    @Test
    public void test2(){

        String str = "beijing";
        str = null;
        Optional<String> str1 = Optional.ofNullable(str);

        String orElse = str1.orElse("上海");

        System.out.println(orElse);


    }
}

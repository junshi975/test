package com.senior.java;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author JUNSHI 405773808@qq.com
 * @description:
 * @create 2020-03-10 19:24
 */
public class exer {
    double price;

    String name;

    public exer() {
    }

    public exer(double price, String name) {
        this.price = price;
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }


    @Test
    public void test(){

        LocalDate localDate = LocalDate.now();//获取当前年月日
        LocalTime localTime = LocalTime.now();//获取当前时间
        LocalDateTime localDateTime = LocalDateTime.now();//获取当前年月日与时间

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

    }

    @Test
    public void test1(){

    }

}

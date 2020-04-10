package com.senior.java1;

import org.junit.Test;

import java.io.PrintStream;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author JUNSHI 405773808@qq.com
 * @description:
 * @create 2020-03-22 12:31
 */
public class Exer {

    @Test
    public void test() {

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("没有使用Lambda");
            }
        };
        r1.run();

        System.out.println("******************");
        Runnable r2 = () -> {
            System.out.println("使用了lambad表达式");
        };
        r2.run();

    }

    @Test
    public void test1() {

        Consumer<String> c1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        c1.accept("没有使用lambda表达式！");

        System.out.println("**********************");

        Consumer<String> c2 = (String s) -> {
            System.out.println(s);
        };
        c2.accept("这个是一个形参的lambad表达式");

    }

    @Test
    public void test2() {

        //类型推断
        ArrayList<String> list = new ArrayList<>();
        int[] arr = {1, 2, 3};

        Consumer<String> c2 = (String s) -> {
            System.out.println(s);
        };
        c2.accept("这个是一个形参的lambad表达式");

        System.out.println("****************");

        Consumer<String> c3 = (s) -> {
            System.out.println(s);
        };

    }

    @Test
    public void test3() {

        Comparator<Integer> c1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {

                System.out.println(o1);
                System.out.println(o2);

                return o1.compareTo(o2);
            }
        };
        System.out.println(c1.compare(2, 1));

        System.out.println("********************");

        Comparator<Integer> c2 = (o1, o2) -> {

            System.out.println(o1);
            System.out.println(o2);

            return o1.compareTo(o2);
        };

        System.out.println(c2.compare(2, 1));


    }

    @Test
    public void test4() {


        Comparator<Integer> c2 = (o1, o2) -> o1.compareTo(o2);

        System.out.println(c2.compare(2, 1));

        Consumer<String> c = s -> System.out.println(s);

    }

    @Test
    public void test5() {

        //表达式之前
        happyTime(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("没有用lambda表达式" + aDouble);
            }
        });

        System.out.println("******************");

        happyTime(500, money -> System.out.println("lambda太爽了" + money));


    }

    public void happyTime(double money, Consumer<Double> con) {
        con.accept(money);
    }

    @Test
    public void test6() {

        List<String> list = Arrays.asList("北京", "南京", "天津", "西京", "三海经");
        List<String> fileterList = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });
        System.out.println(fileterList);

        System.out.println("*******************");

        List<String> filterList1 = filterString(list, s -> s.contains("京"));
        System.out.println(filterList1);


    }


    public List<String> filterString(List<String> list, Predicate<String> pre) {

        ArrayList<String> filterList = new ArrayList<>();

        for (String s : list) {

            if (pre.test(s)) {
                filterList.add(s);
            }
        }

        return filterList;
    }


}

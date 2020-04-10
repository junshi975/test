package com.senior.java2;

import org.junit.Test;

import java.io.PrintStream;
import java.util.*;
import java.util.function.*;

/**
 * @author JUNSHI 405773808@qq.com
 * @description:
 * @create 2020-03-22 15:13
 */
public class Exer {

    //对象::实例方法
    @Test
    public void test() {

        Consumer<String> c = str -> System.out.println(str);
        c.accept("北京");

        System.out.println("**************");

        PrintStream ps = System.out;

        Consumer<String> c1 = ps :: println;
        System.out.println("beijing");

    }

    @Test
    public void test1(){

        Employee em = new Employee(1001,"Tom",42,13332);

        Supplier<String> spl = () -> em.getName();
        System.out.println(spl.get());

        System.out.println("*********************");

        Supplier<String> spl1 = em :: getName;//对象调方法
        System.out.println(spl1.get());

    }

    //类::非静态方法
    @Test
    public void test2(){

        Comparator<Integer> c = (o1,o2) -> Integer.compare(o1,o2);
        System.out.println(c.compare(1,2));

        System.out.println("**************************");

        Comparator<Integer> c1 = Integer::compare;
        System.out.println(c1.compare(1,2));

    }

    @Test
    public void test3(){

        Function<Double,Long> f = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                return Math.round(aDouble);
            }
        };

        Function<Double,Long> f1 = d -> Math.round(d);
        System.out.println(Math.round(12.2));

        System.out.println("*****************");
        Function<Double,Long> f2 = Math::round;
        System.out.println(Math.round(12.5));//四舍五入

    }

    @Test
    public void test4(){

        Comparator<String> c = (o1,o2) -> o1.compareTo(o2);
        System.out.println("sb".compareTo("sb"));

        Comparator<String> c1 = String::compareTo;
        System.out.println("abc".compareTo("abd"));

    }

    @Test
    public void test5(){

        BiPredicate<String,String> bp = (s1,s2) -> s1.equals(s2);
        System.out.println("sb".equals("sb"));

        BiPredicate<String,String> bp1 = String::equals;
        System.out.println("sb".equals("sb"));

    }

    @Test
    public void test6(){

        Employee employee = new Employee(1,"tom",12,123421);

        Function<Employee,String> fun1 = e -> e.getName();
        System.out.println(fun1.apply(employee));

        System.out.println();

        Function<Employee,String> function = Employee::getName;
        System.out.println(function.apply(employee));

    }

    @Test
    public void test7(){

        Supplier<Employee> sup = new Supplier<Employee>() {
            @Override
            public Employee get() {
                return new Employee();
            }
        };
        System.out.println("**********");
        //lamdba
        Supplier<Employee> sup1 = () -> new Employee();
        System.out.println(sup1.get());
        System.out.println("**********");

        Supplier<Employee> sup2 = Employee::new;
        System.out.println(sup2.get());

    }

    @Test
    public void test8(){

        Function<Integer,Employee> func = new Function<Integer, Employee>() {
            @Override
            public Employee apply(Integer integer) {
                return new Employee(integer);
            }
        };//原始方法
        System.out.println();

        Function<Integer,Employee> func1 = id -> new Employee(id);
        Employee apply = func1.apply(134);
        System.out.println(apply);

        System.out.println();

        Function<Integer,Employee> func2 = Employee::new;
        Employee em = func2.apply(213);
        System.out.println(em);

    }

    @Test
    public void test9(){

        BiFunction<Integer,String,Employee> bf = new BiFunction<Integer, String, Employee>() {
            @Override
            public Employee apply(Integer integer, String s) {
                return new Employee(integer,s);
            }
        };

        BiFunction<Integer,String,Employee> bf1 = (age,name) -> new Employee(age,name);
        Employee tom = bf1.apply(13, "Tom");
        System.out.println(tom);

        System.out.println();

        BiFunction<Integer,String,Employee> bf2 = Employee::new;
        System.out.println(bf2.apply(123,"jerry"));

    }

    @Test
    public void test10(){

        Function<Integer,String[]> fun = new Function<Integer, String[]>() {
            @Override
            public String[] apply(Integer integer) {
                return new String[integer];
            }
        };

        Function<Integer,String[]> fun1 = integer -> new String[integer];
        String[] apply = fun1.apply(12);
        System.out.println(Arrays.toString(apply));

        System.out.println();

        Function<Integer,String[]> fun2 = String[]::new;
        String[] apply1 = fun2.apply(3);
        System.out.println(Arrays.toString(apply1));


    }

    @Test
    public void test11(){

        HashMap<String,Integer> map = new HashMap<>();
        map.put("Tom",123);
        map.put("jerry",23);
        map.put("Marry",21);
        map.put("Lisa",27);

        Set<Map.Entry<String, Integer>> set = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = set.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> entry = iterator.next();
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + "-----" + value);

        }


    }
}

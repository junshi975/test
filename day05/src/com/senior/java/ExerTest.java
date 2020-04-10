package com.senior.java;

import org.junit.Test;

import java.util.*;

/**
 * @author JUNSHI 405773808@qq.com
 * @description:
 * @create 2020-03-11 10:32
 */
public class ExerTest {
//
//    private String name;
//    private int age;


//    @Override
//    public int compareTo(Object o) {
//        if (o instanceof ExerTest) {
//            ExerTest exer = (ExerTest) o;
//           return this.name.compareTo(exer.name);
//        }
//        throw new RuntimeException("输入的类型不一致");
//    }

    @Test
    public void test() {

        Collection coll = new ArrayList();

        coll.add("aa");
        coll.add("bb");
        coll.add("234");
        coll.add(new Date());
        coll.add("aa");

        System.out.println(coll.size());
        Collection coll2 = new ArrayList();
        coll.add(4343);
        coll.add(465646);
        coll.addAll(coll);
        System.out.println(coll.size());
        System.out.println(coll);

        coll.clear();

        System.out.println(coll.isEmpty());


    }

    @Test
    public void test1() {
        Collection coll = new ArrayList();
        coll.add(1234);
        coll.add(134);
        coll.add(124);
        coll.add(true);
//        coll.add(new String("ewqr"));
        boolean contains = coll.contains(124);
        System.out.println(contains);
        Collection coll1 = Arrays.asList(123, 124);

        boolean b = coll.containsAll(coll1);
        System.out.println(b);
    }

    @Test
    public void test3() {
        Collection coll = new ArrayList();
        coll.add(1234);
        coll.add(134);
        coll.add(124);
        coll.add(true);

        coll.remove(124);
        coll.remove(124456);
        System.out.println(coll);

        Collection coll1 = Arrays.asList(1234, 134);
        coll.removeAll(coll1);
        System.out.println(coll);

    }

    @Test
    public void test5() {
        Collection coll = new ArrayList();
        coll.add(1234);
        coll.add(134);
        coll.add(124);
        coll.add(true);

//        Collection coll1 = Arrays.asList(134,123,1234);
//        coll.retainAll(coll1);
//        System.out.println(coll);
//        System.out.println(coll.equals(coll1));
        Collection coll2 = new ArrayList();
        coll2.add(134);
        coll2.add(1234);
        coll2.add(124);
        coll2.add(true);
        System.out.println(coll.equals(coll2));
    }

    @Test
    public void test6() {
        Collection coll = new ArrayList();
        coll.add(1234);
        coll.add(134);
        coll.add(124);
        coll.add(true);

        System.out.println(coll.hashCode());
        Object[] objects = coll.toArray();
        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i]);
        }
//
//        List<? extends Cloneable> cloneables = Arrays.asList(new String[]{,}, new int[]{123, 1234});
//        System.out.println(cloneables);

    }

    @Test
    public void test7() {
        Collection coll = new ArrayList();
        coll.add(1234);
        coll.add(134);
        coll.add(124);
        coll.add(true);

        Iterator iterator = coll.iterator();
//        System.out.println(iterator.next());
//        for (int i = 0; i < coll.size(); i++) {
//            System.out.println(iterator.next());
//
//        }
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

    @Test
    public void test9() {
        Collection coll = new ArrayList();
        coll.add(1234);
        coll.add(134);
        coll.add(124);
        coll.add(new String("a"));
        coll.add(true);

        Iterator iterator = coll.iterator();
        while (iterator.hasNext()) {

            Object obj = iterator.next();
//            String c = new String("124");
//            Integer c = new Integer(124);
            if (new Integer(124).equals(obj)) {

                iterator.remove();
            }

        }

        iterator = coll.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

    @Test
    public void testFor() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(1233);
        coll.add(12332);
        coll.add(1233);

        for (Object obj : coll) {
            System.out.println(obj);
        }

        System.out.println("***********************");
//        int[][] arr = new int[][]{{1},{13,13},{34,5},{5}};
//        for(int[][] i,j : arr){
//
//                System.out.println(i,j);

    }

}


class Person {


}

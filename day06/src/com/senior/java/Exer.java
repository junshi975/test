package com.senior.java;


import org.junit.Test;

import java.util.*;

/**
 * @author JUNSHI 405773808@qq.com
 * @description:
 * @create 2020-03-13 18:44
 */
public class Exer {

    @Test
    public void test4() {

        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Person && o2 instanceof Person) {
                    Person p1 = (Person) o1;
                    Person p2 = (Person) o2;
                    return Integer.compare(p1.getAge(), p2.getAge());
                }
                throw new RuntimeException("返回类型不一致");
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        };

        TreeSet list = new TreeSet();
        list.add(new Person("Tom", 124));
        list.add(new Person("Jack", 121));
        list.add(new Person("xiaoming", 12));
        list.add(new Person("Xiaobai", 122));


    }

    @Test
    public void test3() {
        TreeSet tree = new TreeSet();
//        tree.add("aa");类型不一致
//        tree.add(123);
        tree.add(232);
        tree.add(232);
        tree.add(91);
        tree.add(-132);

        Iterator iterator = tree.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test2() {
        Set set = new HashSet();
        set.add(123);
        set.add("AA");
        set.add("BB");
        set.add(new String("CC"));

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test1() {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add("AA");
        list.add(new Person("Tom", 12));
        list.add(new String("BB"));
        list.add(123);

//        Iterator iterator = list.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }

        System.out.println("***************************");
        for (Object obj : list) {
            System.out.println(obj);
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    @Test
    public void test() {

        ArrayList list = new ArrayList();
        list.add(123);
        list.add("AA");
        list.add(new Person("Tom", 12));
        list.add(new String("BB"));
        list.add(123);

        System.out.println(list);

        list.add(1, "bb");
        System.out.println(list);

        List<String> strings = Arrays.asList("CC", "DD");
        list.addAll(strings);
        System.out.println(list.size());
        list.addAll(1, strings);
        System.out.println(list);

        System.out.println(list.get(0));

        int i = list.indexOf(123);
        System.out.println(i);
        int i1 = list.lastIndexOf(123);
        System.out.println(i1);

        Object remove = list.remove(0);
        System.out.println("已删除的元素：" + remove);
        System.out.println(list);

        list.set(2, "BB");
        System.out.println(list);

        List list1 = list.subList(3, 8);
        System.out.println(list1);
        System.out.println("*********************************************");
        for (Object obj : list) {
            System.out.println(list);
        }
        System.out.println("****************************");

        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {

            System.out.println(iterator.next());

        }

        System.out.println("*********************************************");
        for (int j = 0; j < list.size(); j++) {
            System.out.println(list.get(i));
        }
    }

}

package com.senior.java;

import org.junit.Test;

import java.security.Key;
import java.util.*;

/**
 * @author JUNSHI 405773808@qq.com
 * @description:
 * @create 2020-03-14 11:14
 */
public class Exer {

    @Test
    public void test6(){

        Comparator c = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o2 instanceof  User){
                    User u1 = (User) o1;
                    User u2 = (User) o2;
                    return Integer.compare(u1.getAge(),u2.getAge());


                }
                throw new RuntimeException("输入类型不一致");
            }
        };

        Map map = new TreeMap(c);
        User u1 = new User("Tom",12);
        User u2 = new User("AA",15);
        User u3 = new User("TBB",177);
        User u4 = new User("TCB",10);
        map.put(u1,99);
        map.put(u2,90);
        map.put(u3,50);
        map.put(u4,70);

//        Set set = map.keySet();
////        Iterator iterator = set.iterator();
////        while (iterator.hasNext()){
////            Object next1 = iterator.next();
////            Object o = map.get(next1);
////            System.out.println(o + " - " + next1);
//        Set set = map.keySet();
//        Iterator iterator = set.iterator();
//        while (iterator.hasNext()){
//            Object next = iterator.next();
//            Object o = map.get(next);
//            System.out.println(next + " ____ " + o);
//        }
        Set set = map.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            Object key = iterator.next();

            Map.Entry k = (Map.Entry) key;
            System.out.println(k.getKey() + "___" + k.getValue());



        }

    }
    @Test
    public void test5(){
        Map map = new TreeMap();
        User u1 = new User("Tom",12);
        User u2 = new User("AA",15);
        User u3 = new User("TBB",177);
        User u4 = new User("TCB",10);
        map.put(u1,99);
        map.put(u2,90);
        map.put(u3,50);
        map.put(u4,70);

        Set set = map.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            Object key = iterator.next();

            Map.Entry k = (Map.Entry) key;
            System.out.println(k.getKey() + "___" + k.getValue());



        }

    }

    @Test
    public void test4(){
        Map map = new LinkedHashMap();
        map.put(123, "AA");
        map.put(12, "CC");
        map.put("AB", "BB");
        System.out.println(map);




    }
    @Test
    public void test3() {
        Map map = new HashMap();
        map.put(123, "AA");
        map.put(12, "CC");
        map.put("AB", "BB");

//        Set set = map.keySet();
//        Iterator iterator = set.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
//
//        System.out.println("************");
//        Collection values = map.values();
//        for(Object obj : values){
//            System.out.println(obj);
//        }
//        System.out.println("************");

        Set set1 = map.entrySet();
        Iterator iterator1 = set1.iterator();
        while (iterator1.hasNext()){
            Object next = iterator1.next();//返回每个entry
            Map.Entry n = (Map.Entry) next;
            System.out.println(n.getKey() + "____" + n.getValue());

            System.out.println("**************");

            Set set = map.keySet();
            Iterator iterator = set.iterator();
            while (iterator.hasNext()){
                Object next1 = iterator.next();
                Object o = map.get(next1);
                System.out.println(o + " - " + next1);
            }


        }

    }

    @Test
    public void test2() {

        Map map = new HashMap();
//        map = new LinkedHashMap();
        map.put(123, "AA");
        map.put(12, "CC");
        map.put(23, "BB");
        map.put("AA", 234);
        map.put(234, 345);
        map.put("AA", "AA");

        Object o = map.get(12);
        System.out.println(o);

        boolean b = map.containsKey(12);
        System.out.println(b);
        map.clear();
        boolean empty = map.isEmpty();
        System.out.println(empty);
    }

    @Test
    public void test1() {

        Map map = new HashMap();
//        map = new LinkedHashMap();
        map.put(123, "AA");
        map.put(12, "CC");
        map.put(23, "BB");
        map.put("AA", 234);
        map.put(234, 345);
        map.put("AA", "AA");

        System.out.println(map);

        Object remove = map.remove(12);
        System.out.println(remove);
        System.out.println(map);
        map.clear();
        System.out.println(map.size());
        System.out.println(map);
    }

    public static void main(String[] args) {

    }

    @Test
    public void test() {

        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(12893);
        coll.add(13);
        coll.add(12);
        coll.add(1723);

        Iterator iterator = coll.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

}

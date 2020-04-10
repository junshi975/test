package com.senior.exer;

import org.junit.Test;

import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author JUNSHI 405773808@qq.com
 * @description:
 * @create 2020-03-14 12:01
 */
public class EmployeeTest {

    //按照生日的顺序有小到大
    @Test
    public void test1() {

        Comparator com = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Employee && o2 instanceof Employee) {
                    Employee e1 = (Employee) o1;
                    Employee e2 = (Employee) o2;

                    MyDate b1 = e1.getBirthday();
                    MyDate b2 = e2.getBirthday();

                    //方式一
//                    //比较年
//                    int cYear = b1.getYear() - b2.getYear();
//                    if (cYear != 0) {
//                        return cYear;
//                    }
//
//                    //比较月
//                    int cMonth = b1.getMonth() - b2.getMonth();
//                    if (cMonth != 0) {
//                        return cMonth;
//                    }
//
//                    //比较日
//                    return b1.getDay() - b2.getDay();
                    return b1.compareTo(b2);

                }
                throw new RuntimeException("输入类型不一致");
            }
        };

        TreeSet tree = new TreeSet(com);

        Employee e1 = new Employee("liudehua", 55, new MyDate(1988, 03, 03));
        Employee e2 = new Employee("pengyuyan", 5, new MyDate(2588, 01, 03));
        Employee e3 = new Employee("xiaobai", 56, new MyDate(2551, 04, 06));
        Employee e4 = new Employee("wangsicong", 35, new MyDate(2851, 05, 03));
        Employee e5 = new Employee("zhushijum", 19, new MyDate(2001, 03, 03));

        tree.add(e1);
        tree.add(e2);
        tree.add(e3);
        tree.add(e4);
        tree.add(e5);

        Iterator iterator = tree.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

    //使用自然排序
    @Test
    public void test() {

        TreeSet tree = new TreeSet();

        Employee e1 = new Employee("liudehua", 55, new MyDate(1988, 03, 03));
        Employee e2 = new Employee("pengyuyan", 5, new MyDate(2588, 01, 03));
        Employee e3 = new Employee("xiaobai", 56, new MyDate(2551, 04, 06));
        Employee e4 = new Employee("wangsicong", 35, new MyDate(2851, 05, 03));
        Employee e5 = new Employee("zhushijum", 19, new MyDate(2001, 03, 03));

        tree.add(e1);
        tree.add(e2);
        tree.add(e3);
        tree.add(e4);
        tree.add(e5);

        Iterator iterator = tree.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}

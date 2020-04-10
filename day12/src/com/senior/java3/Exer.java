package com.senior.java3;

import com.senior.java2.Employee;
import com.senior.java2.EmployeeData;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author JUNSHI 405773808@qq.com
 * @description:
 * @create 2020-03-22 19:58
 */
public class Exer {

    @Test
    public void test() {

        List<Employee> employees = EmployeeData.getEmployees();
        //返回顺序流
        Stream<Employee> stream = employees.stream();
        //返回并行流
        Stream<Employee> employeeStream = employees.parallelStream();

    }

    @Test
    public void test1() {

        int[] arr = {1, 2, 3, 4, 5};
        IntStream stream = Arrays.stream(arr);

        Employee e1 = new Employee(1, "TOM");
        Employee e2 = new Employee(2, "Marry");
        Employee e3 = new Employee(3, "Jerry");
        Employee[] arre = new Employee[]{e1, e2, e3};
        Stream<Employee> stream1 = Arrays.stream(arre);

    }

    @Test
    public void test2() {

        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4);


    }

    @Test
    public void test3() {

        Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out::println);

        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }

    @Test
    public void test4() {

        List<Employee> list = EmployeeData.getEmployees();

        //filter 排除元素
        list.stream().filter(new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getSalary() > 5000;
            }
        }).forEach(System.out::println);
        list.stream().filter(e -> e.getSalary() > 7000).forEach(System.out::println);
        System.out.println();
        //distinct赛选重复
        list.add(new Employee(1023, "刘强东", 21, 3214));
        list.add(new Employee(1023, "刘强东", 21, 3214));
        list.add(new Employee(1023, "刘强东", 21, 3214));
        list.stream().distinct().forEach(System.out::println);
        System.out.println();
        //limit截断
        list.stream().limit(3).forEach(System.out::println);
        System.out.println();
        //skip跳过
        list.stream().skip(3).forEach(System.out::println);
    }

    @Test
    public void test5() {

//        map(Function f)接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
        List<String> string = Arrays.asList("aa", "cc", "bb", "dd");
        string.stream().map(e -> e.toUpperCase()).forEach(System.out::println);

        System.out.println();

        List<Employee> employees = EmployeeData.getEmployees();
        Stream<String> nameStream1 = employees.stream().map(e -> e.getName());
        nameStream1.filter(name1 -> name1.length() > 3).forEach(System.out::println);

        Stream<String> nameStream = employees.stream().map(Employee::getName);
        nameStream.filter(name -> name.length() > 3).forEach(System.out::println);

        Stream<Stream<Character>> streamStream = string.stream().map(this::fromStringToStream);
        streamStream.forEach(s -> {
            s.forEach(System.out::println);
        });

        System.out.println();
        //方法一
        Stream<Character> characterStream = string.stream().flatMap(new Function<String, Stream<? extends Character>>() {
            @Override
            public Stream<? extends Character> apply(String str) {
                return Exer.this.fromStringToStream(str);
            }
        });
        characterStream.forEach(x -> {
            System.out.println(x);
        });
//        方法二
        Stream<Character> characterStream1 = string.stream().flatMap(str -> Exer.this.fromStringToStream(str));
        characterStream1.forEach(x -> System.out.println(x));
//            方法三
        Stream<Character> characterStream2 = string.stream().flatMap(Exer.this::fromStringToStream);
        characterStream1.forEach(System.out::println);

    }

    public Stream<Character> fromStringToStream(String str) {
        ArrayList<Character> list = new ArrayList<>();
        for (Character c : str.toCharArray()) {
            list.add(c);
        }
        return list.stream();

    }

    @Test
    public void test6() {

        List<Integer> integers = Arrays.asList(12, 32, 0, -1, -34, 325, 95, -65);
        integers.stream().sorted().forEach(System.out::print);

        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().sorted((o1, o2) -> {

            int compare = Integer.compare(o1.getAge(), o2.getAge());
            if (compare != 0) {
                return compare;
            } else {
                return Double.compare(o1.getSalary(), o2.getSalary());
            }

        }).forEach(System.out::println);

    }

    @Test
    public void test7() {
        List<Employee> employees = EmployeeData.getEmployees();

//        allMatch(Predicate p)——检查是否匹配所有元素。
//          练习：是否所有的员工的年龄都大于18
        boolean b = employees.stream().allMatch(e -> e.getAge() > 18);
        System.out.println(b);

//        anyMatch(Predicate p)——检查是否至少匹配一个元素。
//         练习：是否存在员工的工资大于 10000
        boolean b1 = employees.stream().anyMatch(e -> e.getSalary() > 10000);
        System.out.println(b1);

//        noneMatch(Predicate p)——检查是否没有匹配的元素。
//          练习：是否存在员工姓“雷”，返回没有姓雷的
        boolean noneMatch = employees.stream().noneMatch(employee -> employee.getName().contains("雷"));
        System.out.println(noneMatch);

//        findFirst——返回第一个元素
        Optional<Employee> first = employees.stream().findFirst();
        System.out.println(first);
//        findAny——返回当前流中的任意元素
        Optional<Employee> employee1 = employees.parallelStream().findAny();
        System.out.println(employee1);

    }

    @Test
    public void test8() {
        List<Employee> employees = EmployeeData.getEmployees();
        // count——返回流中元素的总个数
        long count = employees.stream().count();
        System.out.println(count);
        System.out.println();
//        max(Comparator c)——返回流中最大值
//        练习：返回最高的工资：
        Optional<Employee> max = employees.stream().max((o1, o2) -> Double.compare(o1.getSalary(), o2.getSalary()));
        System.out.println(max);
        //        min(Comparator c)——返回流中最小值
//        练习：返回最低工资的员工
        System.out.println();
        Optional<Employee> employee = employees.stream().min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(employee);
        System.out.println();
//        forEach(Consumer c)——内部迭代
        employees.stream().forEach(System.out::println);

        //使用集合的遍历操作
        employees.forEach(System.out::println);
    }

    @Test
    public void test9() {

        List<Employee> employees = EmployeeData.getEmployees();

        List<Employee> collect = employees.stream().filter(employee -> employee.getSalary() > 6000).collect(Collectors.toList());
        collect.forEach(System.out::println);

        System.out.println();

        Set<Employee> collect1 = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toSet());
        collect1.forEach(System.out::println);

    }

}

package com.senior.exer;

/**
 * @author JUNSHI 405773808@qq.com
 * @description:
 * @create 2020-03-14 11:59
 */
public class Employee implements Comparable<Employee> {

    private String name;
    private int age;
    private MyDate birthday;

    public Employee(String name, int age, MyDate birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public MyDate getBirthday() {
        return birthday;
    }


    //使用泛型之后
    @Override
    public int compareTo(Employee o) {
        return this.name.compareTo(o.name);
    }


    //姓名从小到大 没有使用泛型

//    @Override
//    public int compareTo(Object o) {
//        if (o instanceof Employee){
//            Employee e = (Employee)o;
//            return this.name.compareTo(e.name);
//        }
//        throw new RuntimeException("输入类型不一致");
//    }

}

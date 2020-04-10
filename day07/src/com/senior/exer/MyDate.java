package com.senior.exer;

/**
 * @author JUNSHI 405773808@qq.com
 * @description:
 * @create 2020-03-14 11:57
 */
public class MyDate implements Comparable{

    private int year;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public MyDate() {
    }

    private int month;

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    private int day;
    //按生日日期从小到大排序
    @Override
    public int compareTo(Object o) {
        if(o instanceof MyDate){
            MyDate m = (MyDate)o;

            //比较年
            int cYear = this.getYear() - m.getYear();
            if (cYear != 0) {
                return cYear;
            }

            //比较月
            int cMonth = this.getMonth() - m.getMonth();
            if (cMonth != 0) {
                return cMonth;
            }

            //比较日
            return this.getDay() - m.getDay();
        }
        throw new RuntimeException("输入类型不一致");
    }
}

package com.senior.java;

/**
 * @author JUNSHI 405773808@qq.com
 * @description:
 * @create 2020-03-10 23:13
 */
public class Goods implements Comparable {

    String name;
    double price;

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Goods() {
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }


    //指明商品比较大小的方式,再按照产品名称从低到高排序
    @Override

    public int compareTo(Object o) {
        if (o instanceof Goods) {
            Goods goods = (Goods) o;

            if (this.price < goods.price) {
                return -1;
            } else if (this.price > goods.price) {
                return 1;
            } else {
//                return 0;
               return this.name.compareTo(goods.name);
            }

        }
        throw new RuntimeException("输入的类型不正确！");
    }


}


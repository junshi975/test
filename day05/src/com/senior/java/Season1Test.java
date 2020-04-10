package com.senior.java;

import javax.sound.sampled.Line;

/**
 * @author JUNSHI 405773808@qq.com
 * @create 2020-03-12 11:17
 */
public class Season1Test {
    public static void main(String[] args) {

        Season1 summer = Season1.SUMMER;
        System.out.println(summer);

        System.out.println("*******************");
        //values()://查看枚举类有几个状态
        Season1[] values = Season1.values();
        for(int i = 0;i < values.length;i++){
            System.out.println(values[i]);
        }

        Thread.State[] values1 = Thread.State.values();
        for(int i = 0;i < values1.length;i++){
            System.out.println(values1[i]);
        }

        //valueOf(String objName):返回枚举类中对象名是objName的对象
        //如果没有objName的枚举类对象，则抛异常：IlleagalArgumentException
        Season1 winter = Season1.valueOf("WINTER");//根据WINTER这个名字找到枚举类中的对象
//        Season1 winter = Season1.valueOf("WINTER1");//IlleagalArgumentExceptio
        System.out.println(winter);

        winter.show();


    }

}
interface Info{
    void show();
}

//使用enum定义枚举类
enum Season1 implements Info{


    //3.提供当前枚举类的多个对象，多个对象中用","隔开，末尾对象用";"结束
    SPRING("春天", "春暖花开"){
        //   情况二：让枚举类的对象分别实现接口中的抽象方法
        @Override
        public void show() {
            System.out.println("春天~");
        }
    },
    SUMMER("夏天", "夏日炎炎"){
        @Override
        public void show() {
            System.out.println("夏天");
        }
    },
    AUTUMN("秋天", "秋高气爽"){
        @Override
        public void show() {
            System.out.println("秋天");
        }
    },
    WINTER("冬天", "冰天雪地"){
        @Override
        public void show() {
            System.out.println("冬天");
        }
    };


    //2.声明Season对象的属性：private final修饰
    private final String seasonName;
    private final String seasonDesc;


    //3.提供私有的构造器，并对属性赋值
    private Season1(String seasonName, String seasonDesc) {
        this.seasonDesc = seasonDesc;
        this.seasonName = seasonName;
    }


    //4.获取枚举类对象的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

//   情况一：实现接口，在enum类中实现抽象方法
//    @Override
//    public void show() {
//        System.out.println("这是个季节！");
//    }


//    //提供toString
//    @Override
//    public String toString() {
//        return "Season{" +
//                "seasonName='" + seasonName + '\'' +
//                ", seasonDesc='" + seasonDesc + '\'' +
//                '}';
//    }
}

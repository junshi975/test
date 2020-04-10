package com.senior.exer;

/**
 * 练习：创建两个分线程，其中一个线程遍历100以内的偶数，另一个线程遍历100以内的奇数
 *
 * @author JUNSHI 405773808@qq.com
 * @create 2020-03-02 21:35
 */
public class ThreadDemo {
    public static void main(String[] args) {
//        MyThread1 m1 = new MyThread1();
//        MyThread2 m2 = new MyThread2();
//
//        m1.start();
//        m1.start();

        //创建Thread匿名对象的匿名子类
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if ((i % 2) == 0) {
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                    }

                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if ((i % 2) != 0) {
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                    }

                }
            }
        }.start();

    }

}

class MyThread1 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if ((i % 2) == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }

        }
    }
}

class MyThread2 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if ((i % 2) != 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }

        }
    }
}


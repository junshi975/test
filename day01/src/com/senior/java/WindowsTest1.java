package com.senior.java;

/**
 * 创建三个窗口卖票，总数100张使用实现Runnable接口的方法
 * 存在线程安全的问题
 *
 * @author JUNSHI 405773808@qq.com
 * @create 2020-03-02 23:06
 */
public class WindowsTest1 {
    public static void main(String[] args) {
        Windows1 w = new Windows1();//实现windows1

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口1");//线程的名字
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();

    }
}

class Windows1 implements Runnable {
    private int ticket = 100;//此时不用static是因为只创建了一个对象

    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
                //windows1没有继承Thread
                System.out.println(Thread.currentThread().getName() + "卖票：" + ticket);
            } else {
                break;
            }
        }

    }


}

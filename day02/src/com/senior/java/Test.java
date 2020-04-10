package com.senior.java;

import com.sun.org.apache.bcel.internal.generic.NEW;
import sun.awt.windows.ThemeReader;

/**
 * @author JUNSHI 405773808@qq.com
 * @create 2020-03-03 23:46
 */
public class Test extends Thread {
    public static void main(String[] args) {
        Windows5 w5 = new Windows5();
        Thread t1 = new Thread(w5);
        Thread t2 = new Thread(w5);
        Thread t3 = new Thread(w5);
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();



    }


}

class Windows5 implements Runnable{
    private int ticket = 100;
    @Override
    public void run() {
        while (true){
           synchronized (this){
               if (ticket > 0){
                   System.out.println(Thread.currentThread().getName() + "卖票：" + ticket);
                   ticket--;
               }else{
                   break;
               }
           }




        }
    }
}

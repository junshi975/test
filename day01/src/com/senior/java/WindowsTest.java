package com.senior.java;

/**
 *
 * 创建三个窗口卖票 总共100张
 *
 * @author JUNSHI 405773808@qq.com
 * @create 2020-03-02 22:49
 */

public class WindowsTest {
    public static void main(String[] args) {
        Windows t1 = new Windows();
        Windows t2 = new Windows();
        Windows t3 = new Windows();

        t1.start();
        t2.start();
        t3.start();

    }


}

class Windows extends Thread{

    private static int ticket = 100;

    @Override
    public void run() {

        while (true){

            if(ticket > 0){
                System.out.println(getName() + "卖票票号为：" + ticket);
                ticket--;
            }else{
                break;
            }
        }
    }
}
package com.senior.java2;

/**
 * 生产者(Productor)将产品交给店员(Clerk)，而消费者(Customer)从店员处
 * 取走产品，店员一次只能持有固定数量的产品(比如:20），如果生产者试图
 * 生产更多的产品，店员会叫生产者停一下，如果店中有空位放产品了再通
 * 知生产者继续生产；如果店中没有产品了，店员会告诉消费者等一下，如
 * 果店中有产品了再通知消费者来取走产品。
 *
 * 分析：是否是多线程：是，生产者线程  消费者线程
 *      是否共享数据 ： 是 店员或产品
 *      如何解决线程安全问题：同步机制 有三种方法
 *      是否涉及线程的通信：是
 * @author JUNSHI 405773808@qq.com
 * @create 2020-03-04 16:31
 */

class Clerk{
    private int productCount = 0;//产品的数量
    //生产产品
    public synchronized void produceProduct(){//同步方法

        if(productCount < 20){
            productCount++;
            System.out.println(Thread.currentThread().getName() + ":开始生产第：" + productCount);

            notify();//只要生产了一个产品就要唤醒一个消费者
        }else{
          //等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    //消费产品
    public synchronized void comusterProduct() {//同步方法
        if(productCount > 0){
            System.out.println(Thread.currentThread().getName() + ":开始消费第：" + productCount);
            productCount--;

            notify();//只要消费了一个产品就可以唤醒生产者
        }else{
            //等待
            try {
                wait();//只能使用在同步代码块中或同步方法中
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer extends Thread{//生产者

    private Clerk clerk;

    public Producer(Clerk clerk){

        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + "开始生产....");
        while (true){

            try {
                sleep(10);//生产快一些
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.produceProduct();
        }
    }
}

class Custumer extends Thread{//消费者

    private Clerk clerk;

    public Custumer(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + "开始消费....");
        while (true){
            try {
                sleep(20);//消费慢
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.comusterProduct();
        }
    }
}


public class ProductTest {

    public static void main(String[] args) {

        Clerk clerk = new Clerk();

        Custumer c1 = new Custumer(clerk);
        Producer p1 = new Producer(clerk);

        c1.setName("客户1");
        p1.setName("客户2");

        c1.start();
        p1.start();


    }
}

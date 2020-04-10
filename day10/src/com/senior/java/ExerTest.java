package com.senior.java;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author JUNSHI 405773808@qq.com
 * @description:
 * @create 2020-03-18 9:52
 */
public class ExerTest {

    public static void main(String[] args) {

        try {

            InetAddress inet1 = InetAddress.getByName("www.baidu.com");

            System.out.println(inet1);

            InetAddress inet2 = InetAddress.getByName("127.0.0.1");

            System.out.println(inet2);

            InetAddress inet3 = InetAddress.getLocalHost();

            System.out.println(inet3);



        } catch (UnknownHostException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void test5() {

        RandomAccessFile rdf = null;
        try {
            rdf = new RandomAccessFile(new File("hello.txt"), "rw");

            rdf.seek(3);//将指针调到角标为3的地方

            byte[] buffer = new byte[20];
            int len;
            //保存指针3后面的所有数据到StringBuilder中
            StringBuilder builder = new StringBuilder((int) new File("hello.txt").length());
            while ((len = rdf.read(buffer)) != -1) {
                builder.append(new String(buffer, 0, len));
            }

            //调回指针
            rdf.seek(3);
            rdf.write("xyz".getBytes());

            //将StringBuilder中的数据写入到文件中
            rdf.write(builder.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (rdf != null) {

                try {
                    rdf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }


    }

    @Test
    public void test4() {

        RandomAccessFile rdf = null;
        RandomAccessFile rdf1 = null;
        try {
            rdf = new RandomAccessFile(new File("爱情与友情.jpg"), "r");
            rdf1 = new RandomAccessFile(new File("爱情与友情1.jpg"), "rw");

            byte[] b = new byte[1024];
            int len;
            while ((len = rdf.read(b)) != -1) {
                rdf1.write(b, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (rdf != null) {

                try {
                    rdf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (rdf1 != null) {

                try {
                    rdf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }


    }

    @Test
    public void test3() {

        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("object.dat"));


            Object o = ois.readObject();
            String str = (String) o;
            System.out.println(str);

            Person1 p = (Person1) ois.readObject();
            System.out.println(p);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {

                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }


    @Test
    public void test2() {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("object.dat"));

            oos.writeObject(new String("我爱中国！"));
            oos.flush();

            oos.writeObject(new Person1("小黄", 11));
            oos.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {

                try {
                    oos.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }


    }

    @Test
    public void test1() {

        InputStreamReader isr = null;//字节转字符
        OutputStreamWriter opw = null;
        try {
            isr = new InputStreamReader(new FileInputStream(new File("hello.txt")), "UTF-8");
            opw = new OutputStreamWriter(new FileOutputStream(new File("hello_bgk.txt")), "GBK");

            char[] b = new char[5];
            int len;
            while ((len = isr.read(b)) != -1) {
                opw.write(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (isr != null) {

                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (opw != null) {

                try {
                    opw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }


    }

    @Test
    public void test() {

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(new File("hello.txt")));
            bos = new BufferedOutputStream(new FileOutputStream(new File("hello1.txt")));

            byte[] b = new byte[5];
            int len;
            while ((len = bis.read(b)) != -1) {
                bos.write(b, 0, len);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {

                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bos != null) {

                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }


}

class Person1 implements Serializable {

    public static final long serialVersionUID = 12423142342L;

    private String name;
    private int age;

    public Person1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person1() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public int getAge() {
        return age;
    }
}
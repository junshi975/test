package com.senior.java;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * 涉及到String类与其他结构之间的转换
 *
 * @author JUNSHI 405773808@qq.com
 * @create 2020-03-08 17:18
 */
public class StringTest1 {

    /*
    编码：String --> byte[]:调用String的getBytes()
    解码：byte[] --> String:调用String的构造器

    编码：字符串 -->字节  (看得懂 --->看不懂的二进制数据)
    解码：编码的逆过程，字节 --> 字符串 （看不懂的二进制数据 ---> 看得懂）

    说明：解码时，要求解码使用的字符集必须与编码时使用的字符集一致，否则会出现乱码。

     */
    @Test
    public void test3() throws UnsupportedEncodingException {
        String str1 = "abc123中国";
        byte[] bytes = str1.getBytes();//使用默认的字符集，进行编码。
        System.out.println(Arrays.toString(bytes));

        byte[] gbks = str1.getBytes("gbk");//使用gbk字符集进行编码。
        System.out.println(Arrays.toString(gbks));

        System.out.println("******************");

        String str2 = new String(bytes);//使用默认的字符集，进行解码。
        System.out.println(str2);

        String str3 = new String(gbks);
        System.out.println(str3);//出现乱码。原因：编码集和解码集不一致！


        String str4 = new String(gbks, "gbk");
        System.out.println(str4);//没有出现乱码。原因：编码集和解码集一致！
    }



   /*
   String 与 char[]之间的转换

   String --> char[] 调用String的toCharArray();
   char[] --> String 调用String的构造器
    */

    @Test
    public void test1() {
        String s1 = "abc123";

        char[] charArray = s1.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            System.out.println(charArray[i]);
        }

        char[] arr = new char[]{'a', 'b', 'c'};
        String s2 = new String(arr);
        System.out.println(s2);


    }


    @Test
    public void test() {
        /*
        复习：
        String 与基本数据类型、包装类之间的转换
        String --> 基本数据类型，包装类：调用包装类的ParseXxx
        基本数据类型。包装类--> String: 调用String重载的ValueOf(xxx)
         */
        String s1 = "123";
//        int num = (int)s1;
        int num = Integer.parseInt(s1);//String --> 基本数据类型，包装类：调用包装类的ParseXxx

        String s2 = String.valueOf(num);//基本数据类型。包装类--> String
        String s3 = num + "";

        System.out.println(s1 == s3);//false

    }

    @Test
    public void test4() {

        StringBuffer s1 = new StringBuffer("ABC");
        s1.append(1);
        s1.append('2');
        System.out.println(s1);//ABC12
//        s1.delete(1,2);//AC12
//        s1.replace(2,4,"hello");//ABhello2
//        s1.insert(2,"false");//ABfalseC12
        s1.reverse();//反转 21CBA
        System.out.println(s1);


    }
    @Test
    public void test5(){
        long time = System.currentTimeMillis();
        //称为时间戳
        System.out.println(time);
    }
    @Test
    public void testSubString(){
       String str = "abcdef";
        System.out.println(str);
        String substring = str.substring(1, 3);
        System.out.println(substring);//bc

    }
}




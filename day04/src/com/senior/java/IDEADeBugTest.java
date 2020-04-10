package com.senior.java;

import org.junit.Test;

/**
 * @author JUNSHI 405773808@qq.com
 * @create 2020-03-09 16:12
 */
public class IDEADeBugTest {

    @Test
    public void test() {
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);
        System.out.println(sb.length());//4
        System.out.println(sb);//"null"
        StringBuffer sb1 = new StringBuffer(str);//抛异常
        System.out.println(sb1);//


    }
    @Test
    public void test1(){

    }

}

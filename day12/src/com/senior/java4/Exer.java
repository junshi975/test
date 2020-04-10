package com.senior.java4;

import org.junit.Test;

import java.util.Arrays;
import java.util.Optional;

/**
 * @author JUNSHI 405773808@qq.com
 * @description:
 * @create 2020-03-23 0:14
 */
public class Exer {

    public String getGrilName(Boy boy){
        return boy.getGirl().getName();
    }

    public String getGrilName1(Boy boy){

        if (boy != null){
            Girl girl = boy.getGirl();

            if (girl != null){
                return girl.getName();
            }
        }
        return null;
    }

    @Test
    public void test(){

        Boy boy = new Boy();
        String grilName = getGrilName(boy);
        System.out.println(grilName);


    }
    @Test
    public void test1(){

        Boy boy = new Boy();
        String grilName = getGrilName1(boy);
        System.out.println(grilName);


    }

    public String getGrilName2(Boy boy){

        Optional<Boy> boyOptional = Optional.ofNullable(boy);

        Boy boy1 = boyOptional.orElse(new Boy(new Girl("小白")));

        Girl girl = boy1.getGirl();

        Optional<Girl> girlOptional = Optional.ofNullable(girl);
        Girl girl1 = girlOptional.orElse(new Girl("小红"));

        return girl1.getName();


    }
    @Test
    public void test5(){

        int[] arr = {1,2,4};
        System.out.println(Arrays.toString(arr));
        System.out.println();

    }
}

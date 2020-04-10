package com.senior.exer;

import org.junit.Test;

/**
 * @author JUNSHI 405773808@qq.com
 * @create 2020-03-11 20:45
 */
public class StringDemo1 {
    //获取一个字符串在另一个字符串中出现的次数。
    //比如：获取“ ab”在 “abkkcadkabkebfkabkskab” 中出现的次数

    /**
     * 获取subStr在mainStr出现的次数
     * @param mainStr
     * @param subStr
     * @return
     */
    public int getCount(String mainStr,String subStr){

        int mainLength = mainStr.length();
        int subLength = subStr.length();
        int count = 0;//记录出现的次数
        int index = 0;

        //首先需要判断mianStr的长度是否大于等于subStr的长度，如果不大于则没得比
        if(mainLength >= subLength){

            //方式一：
            //indexOf()  返回subStr的字符串在mainStr中出现的索引，如果索引不是-1代表找到
//            while ((index = mainStr.indexOf(subStr)) != -1){
//                count++;
//                //找到了subStr字符串后，截取在出现相同字符后mainStr的子串
//                mainStr = mainStr.substring(index + subLength);
//
//            }
            //方式二：在原有的字符串中操作
            //返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始
            while ((index = mainStr.indexOf(subStr, index)) != -1){//从索引0处开始找
                count++;
                index += subLength;

            }
            return count;
        }else{

            return 0;

        }

    }

    @Test
    public void testGetCount(){

        String mianStr = "abkkcadkabkebfkabkskab";
        String subStr = "ab";

        int count = getCount(mianStr, subStr);
        System.out.println(count);//4
    }



}

package com.senior.exer;

import org.junit.Test;

import static jdk.nashorn.internal.objects.NativeString.substring;

/**
 * @author JUNSHI 405773808@qq.com
 * @description: String 的练习题
 * @create 2020-03-11 14:18
 */
public class StringDemo {

    /*
       将一个字符串进行反转。将字符串中指定部分进行反转。比如“abcdefg”反转为”abfedcg”

       方式一：转换为char[]
        */
    public String reverse(String str, int startIndex, int endIndex) {

        if (str != null) {
            char[] arr = str.toCharArray();//String 转char[]数组
            for (int x = startIndex, y = endIndex; x < y; x++, y--) { //x向后y向前//进行数组反转
                char temp = arr[x];
                arr[x] = arr[y];
                arr[y] = temp;


            }

            return new String(arr);
        }
        return null;
    }

    //方式二：string 的拼接 先把数组第一部分startIndex前的元素取出来
//   比如“abcdefg”反转为”abfedcg” 将ab一部分不变取出来 在把第二部分cde反转拼接到第一部分后边 最后把第三部分没反转的fg拼接
    public String reverse1(String str, int startIndex, int endIndex) {

       if(str != null){
           //第一部分将需要反转的数组startIndex前的元素取出来先
           String str1 = str.substring(0,startIndex);
           //第二部分 再把反转后的第二部分拼接到第一部分
           for(int i = endIndex;i >= startIndex ;i--){//倒着取第二部分 终止条件的意思是要取到开始的这个元素e (倒回来后abedcfg)
               //charAt() 返回 char指定索引处的值。
               str1 += str.charAt(i);//取每个字符拼接到第一部分中
           }
           //第三部分
           //返回一个新的字符串，它是此字符串的从endIndex + 1开始截取到最后的一个子字符串。
           str1 += str.substring(endIndex + 1);//不+1的话会把e也取出来
        return str1;
       }
        return null;
    }


    //方法三:使用StringBuffer/StringBuilder替换String
    public String reverse2(String str, int startIndex, int endIndex) {

        if(str != null){
            //此时没有涉及多线程可以使用StringBuilder提高效率
            StringBuilder builder = new StringBuilder(str.length());//造一个在原有数组长度+16的长度


            //第一部分
            builder.append(str.substring(0,startIndex));//与方式二差不多方法 将元素添加到builder中
            //第二部分，反转
            for(int i = endIndex;i >= startIndex ;i--){

                builder.append(str.charAt(i));//在原有的数组操作

            }
            //第三部分：
            builder.append(str.substring(endIndex + 1));

            return builder.toString();//返回数组的元素打印

        }
        return null;


    }


        @Test
    public void test() {
        String str = new String("abcdefg");
        String reverse = reverse1(str, 2, 5);
        System.out.println(reverse);//此时成功反转成abedcfg
    }


}

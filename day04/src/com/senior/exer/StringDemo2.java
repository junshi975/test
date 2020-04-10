package com.senior.exer;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author JUNSHI 405773808@qq.com
 * @create 2020-03-11 22:37
 */
public class StringDemo2 {
    /*
   获取两个字符串中最大相同子串。比如：
  str1 = "abcwerthelloyuiodefabcdef";str2 = "cvhellobnm"
  提示：将短的那个串进行长度依次递减的子串与较长的串比较。
  从长的往短的找
    */
    //前提只有一对最大相同子串
    public String getMaxSameString(String str1, String str2) {

        if (str1 != "null" && str2 != "null") {
            //先判断str1与str2的长度
            String maxStr = (str1.length() >= str2.length()) ? str1 : str2;//返回长度大的str  判断str1长度是否大于str2
            String minStr = (str1.length() < str2.length()) ? str1 : str2;//返回长度短的str 判断str1长度是否小于str2的长度
            int length = minStr.length();
            //外层大轮，去掉的元素不能要小于字符串的长度
            for (int i = 0; i < length; i++) {//每一轮考虑去掉一个字符
                //一大轮去一个字符
                for (int x = 0, y = length - i; y <= length; x++, y++) {//先让x从0开始
                    //返回一个新字符串，它是此字符串从beginIndex开始截取到endIndex(不包含)的一个子字符串。
                    String subStr = minStr.substring(x, y);//开始是x 结束是y 。第一大轮后返回的是有消去元素的字符串
                    //contains(CharSequence s)：当且仅当此字符串包含指定的 char 值序列 时，返回 true
                    if (maxStr.contains(subStr)) {//如果当前maxStr里包含有subStr字符时返回true
                        return subStr;
                    }

                }
            }
        }
        return null;
    }

    // 如果存在多个长度相同的最大相同子串
    // 此时先返回String[]，后面可以用集合中的ArrayList替换，较方便
    public String[] getMaxSameString1(String str1, String str2) {
        if (str1 != null && str2 != null) {
            StringBuffer sBuffer = new StringBuffer();
            String maxString = (str1.length() > str2.length()) ? str1 : str2;
            String minString = (str1.length() > str2.length()) ? str2 : str1;

            int len = minString.length();
            for (int i = 0; i < len; i++) {
                for (int x = 0, y = len - i; y <= len; x++, y++) {
                    String subString = minString.substring(x, y);
                    if (maxString.contains(subString)) {
                        sBuffer.append(subString + ",");
                    }
                }
//                System.out.println(sBuffer);
                if (sBuffer.length() != 0) {
                    break;
                }
            }
            String[] split = sBuffer.toString().replaceAll(",$", "").split("\\,");
            return split;
        }

        return null;
    }

    @Test
    public void testGetMaxSameString() {
        String str1 = "abcwerthello1yuiodefabcdef";
        String str2 = "cvhello1bnmabcdef";
        String[] maxSameStrings = getMaxSameString1(str1, str2);
        System.out.println(Arrays.toString(maxSameStrings));

    }
}

package com.senior.java;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * jdk 8中日期时间API的测试
 *
 * @author shkstart
 * @create 2019 下午 2:44
 */
public class JDK8DateTimeTest {

    @Test
    public void testDate() {
        //偏移量
        Date date1 = new Date(2020 - 1900, 9 - 1, 8);
        System.out.println(date1);//Tue Sep 08 00:00:00 GMT+08:00 2020
    }

    /*
    LocalDate、LocalTime、LocalDateTime 的使用
    说明：
        1.LocalDateTime相较于LocalDate、LocalTime，使用频率要高
        2.类似于Calendar
     */
    @Test
    public void test1() {
        //！now():获取当前的日期、时间、日期+时间
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        //！of():设置指定的年、月、日、时、分、秒。没有偏移量
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 10, 6, 13, 23, 43);
        System.out.println(localDateTime1);//2020-03-10


        //getXxx()：获取相关的属性
        System.out.println(localDateTime.getDayOfMonth());//获取当月第几日
        System.out.println(localDateTime.getDayOfWeek());//获取当周时间
        System.out.println(localDateTime.getMonth());//获取当月
        System.out.println(localDateTime.getMonthValue());//获取当月
        System.out.println(localDateTime.getMinute());//当前时间分钟

        //体现不可变性
        //withXxx():设置相关的属性
        LocalDate localDate1 = localDate.withDayOfMonth(22);
        System.out.println(localDate);//此时原有时间未改变
        System.out.println(localDate1);//localDate1接收新的时间


        LocalDateTime localDateTime2 = localDateTime.withHour(4);
        System.out.println(localDateTime);
        System.out.println(localDateTime2);

        //不可变性
        LocalDateTime localDateTime3 = localDateTime.plusMonths(3);//在现有时间中加上3个月
        System.out.println(localDateTime);
        System.out.println(localDateTime3);

        LocalDateTime localDateTime4 = localDateTime.minusDays(6);//在原有时间中减去6天
        System.out.println(localDateTime);//原有localDateTime不变
        System.out.println(localDateTime4);
    }

    /*
    Instant的使用
    类似于 java.util.Date类

     */
    @Test
    public void test2() {
        //now():获取本初子午线对应的标准时间 伦敦时间
        Instant instant = Instant.now();//实例化Instant
        System.out.println(instant);//2019-02-18T07:29:41.719Z

        //因为本初子午线与北京时间相差8小时，添加时间的偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);//2019-02-18T15:32:50.611+08:00

        //toEpochMilli():获取自1970年1月1日0时0分0秒（UTC）开始的毫秒数  ---> 类似于Date类的getTime()
        long milli = instant.toEpochMilli();
        System.out.println(milli);

        //ofEpochMilli():通过给定的毫秒数，获取Instant实例  -->相当Date(long millis)
        Instant instant1 = Instant.ofEpochMilli(1550475314878L);
        System.out.println(instant1);
    }

    /*
    DateTimeFormatter:格式化或解析日期、时间
    类似于SimpleDateFormat

     */

    @Test
    public void test3() {
//        方式一：预定义的标准格式。如：ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        //格式化:日期-->字符串
        LocalDateTime localDateTime = LocalDateTime.now();
        String str1 = formatter.format(localDateTime);
        System.out.println(localDateTime);
        System.out.println(str1);//2020-03-10T22:08:38.437

        //解析：字符串 -->日期
        TemporalAccessor parse = formatter.parse("2020-03-10T22:08:38.437");
        System.out.println(parse);

//        方式二：
//        本地化相关的格式。如：ofLocalizedDateTime()
//        FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT :适用于LocalDateTime
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
        //格式化
        String str2 = formatter1.format(localDateTime);
        System.out.println(str2);//2020年3月10日 下午10时09分13秒


//      本地化相关的格式。如：ofLocalizedDate()
//      FormatStyle.FULL / FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT : 适用于LocalDate
        DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        //格式化
        String str3 = formatter2.format(LocalDate.now());
        System.out.println(str3);//2020-3-10


//       重点： 方式三：自定义的格式。如：ofPattern(“yyyy-MM-dd hh:mm:ss”)
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        //格式化
        String str4 = formatter3.format(LocalDateTime.now());
        System.out.println(str4);//2020-03-10 10:09:13

        //解析 字符串转日期时间
        TemporalAccessor accessor = formatter3.parse("2020-03-10 10:09:13");
        System.out.println(accessor);

    }

}

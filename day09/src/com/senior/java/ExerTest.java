package com.senior.java;

import org.hamcrest.core.StringEndsWith;
import org.junit.Test;
import sun.java2d.pipe.SpanIterator;

import javax.swing.*;
import javax.swing.text.html.parser.Entity;
import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.MarshalledObject;
import java.sql.SQLOutput;
import java.util.*;

/**
 * @author JUNSHI 405773808@qq.com
 * @description:
 * @create 2020-03-17 9:00
 */
public class ExerTest {

    @Test
    public void testServer() {

        ServerSocket serverSocket = null;
        Socket accept = null;
        InputStream inputStream = null;
        ByteArrayOutputStream byteArrayInputStream = null;
        try {
            serverSocket = new ServerSocket(8080);

            accept = serverSocket.accept();

            inputStream = accept.getInputStream();

            byteArrayInputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[5];
            int len;
            while ((len = inputStream.read(buffer)) != -1){
                byteArrayInputStream.write(buffer,0,len);
            }

            System.out.println(byteArrayInputStream.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(serverSocket != null){

                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (accept != null){

                try {
                    accept.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null){

                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (byteArrayInputStream != null){

                try {
                    byteArrayInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }


    @Test
    public void test10() {

        BufferedReader bfr = null;
        BufferedWriter bfw = null;
        try {
            bfr = new BufferedReader(new FileReader(new File("hello.txt")));
            bfw = new BufferedWriter(new FileWriter(new File("hello3.txt")));

//            char[] c = new char[1024];
//            int len;
//            while ((len = bfr.read(c)) != -1){
//                bfw.write(c,0,len);
//            }
            String str;
            while ((str = bfr.readLine()) != null){
//                1.
//                bfw.write(str + "\n");
//                2
                bfw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bfr != null){

                try {
                    bfr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bfw != null){

                try {
                    bfw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    @Test
    public void test9(){

        BufferedInputStream buip = null;
        BufferedOutputStream boip = null;
        try {
            File scrFile = new File("io.jpg");
            File copyFile  = new File("io2.jpg");

            FileInputStream scr = new FileInputStream(scrFile);
            FileOutputStream out = new FileOutputStream(copyFile);

            buip = new BufferedInputStream(scr);
            boip = new BufferedOutputStream(out);

            byte[] b = new byte[5];
            int len;
            while ((len = buip.read(b)) != -1){
                boip.write(b,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (buip != null){

                try {
                    buip.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (boip != null){

                try {
                    boip.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    @Test
    public void testCopy(){

        long l = System.currentTimeMillis();

        String srcPath = "C:\\Users\\JUN\\Desktop\\io.avi";
        String copyPath = "C:\\Users\\JUN\\Desktop\\io1.avi";
        copyFile(srcPath,copyPath);

        long l1 = System.currentTimeMillis();
        System.out.println(l1 - l);

    }

    public void copyFile(String srcPath,String copyPath){
        FileInputStream fip = null;
        FileOutputStream fop = null;
        try {
            File scrFile = new File(srcPath);
            File copyFile = new File(copyPath);

            fip = new FileInputStream(scrFile);
            fop = new FileOutputStream(copyFile);

            byte[] b = new byte[1024];
            int len;
            while ((len = fip.read(b)) != -1){

                fop.write(b,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if(fip != null)
                    fip.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fop != null)
                    fop.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    @Test
    public void test8() {

        FileInputStream fip = null;
        FileOutputStream fop = null;
        try {
            File scrFile = new File("io.jpg");
            File copyFile = new File("io1.jpg");

            fip = new FileInputStream(scrFile);
            fop = new FileOutputStream(copyFile);

            byte[] b = new byte[5];
            int len;
            while ((len = fip.read(b)) != -1){

                fop.write(b,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if(fip != null)
                fip.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fop != null)
                fop.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
    @Test
    public void test7(){

        java.lang.String[] str = new java.lang.String[]{"AA","BB","CC"};

        for (int i = 0; i < str.length;i++){
            System.out.println(str[i]);
        }

        for (java.lang.String arr : str){
            System.out.println(arr);
        }


    }

    @Test
    public void test6()  {

        FileInputStream fis = null;
        try {
            File file = new File("hello.txt");

            fis = new FileInputStream(file);

            byte[] txt = new byte[5];
            int len;
            while ((len = fis.read(txt)) != -1 ){

                java.lang.String str = new java.lang.String(txt,0,len);
                System.out.println(str);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (fis != null)
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }

    @Test
    public void test5()  {

        FileReader fr = null;//输入
        FileWriter fw = null;//输出
        try {
            File srcFile = new File("hello.txt");//读入文件
            File copyFile = new File("hello2.txt");

            fr = new FileReader(srcFile);
            fw = new FileWriter(copyFile);

            char[] type = new char[5];
            int len;
            while ((len = fr.read(type)) != -1){

                fw.write(type);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (fr != null)
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fw != null)
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }

    @Test
    public void test4() throws IOException {

        File file = new File("hello1.txt");

        FileWriter fw = new FileWriter(file);

        fw.write("I hava a dream!\n");
        fw.write("you need to hava a dream!");

        fw.close();



    }
    @Test
    public void test3()  {

        FileReader Fr = null;
        try {
            File file = new File("hello.txt");

            Fr = new FileReader(file);

            char[] sbuf = new char[5];

//            read(char[] cbuf)：返回每次读入cbuf数组中的字符的个数

            int len;
            while ( (len = Fr.read(sbuf)) != -1){

                for (int i = 0; i < len;i++){

                    System.out.print(sbuf[i]);
                }

            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (Fr != null){

                try {
                    Fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void test2() {

//            public ArrayList<String> getValuesList(HashMap<String,String> map){
//
//
//                List<String> list = new ArrayList<>();
//                Collection<String> values = map.values();
//
//                for (String value : values){
//                    list.add(value);
//                }
//
//                return list;
//
//
//            }

    }

    @Test
    public void test1() {

        List<String> list = new ArrayList<>();

        for (String l : list) {

            System.out.println(l);
        }

        List<String> list2 = new ArrayList<>();

        Iterator<String> iterator = list2.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }


    }

    @Test
    public void test() {

        Map<String, Integer> map = new HashMap<>();
//        Map.put();
        Set<String> mapSet = map.keySet();
        for (String set : mapSet) {
            System.out.println(set);
        }

        Collection<Integer> values = map.values();
        Iterator<Integer> iterator = values.iterator();
        while (iterator.hasNext()) {

            System.out.println(iterator.next());//values

        }

        Set<Map.Entry<String, Integer>> mpSet = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator1 = mpSet.iterator();
        while (iterator1.hasNext()) {
            Map.Entry<String, Integer> entry = iterator1.next();
            String key = entry.getKey();
            Integer value = entry.getValue();

            System.out.println(key + "---" + value);

        }


    }

}

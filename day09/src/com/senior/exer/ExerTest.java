package com.senior.exer;

import com.sun.org.apache.xml.internal.serializer.OutputPropertiesFactory;
import org.junit.Test;
import sun.management.FileSystem;

import javax.sound.midi.Soundbank;
import java.io.*;

/**
 * @author JUNSHI 405773808@qq.com
 * @description:
 * @create 2020-03-17 22:31
 */
public class ExerTest {

    @Test
    public void test2() throws FileNotFoundException {

        DataInputStream data = new DataInputStream(new FileInputStream(new File("hello.txt")));




    }

    public static void main(String[] args) {

        BufferedReader bfrd = null;
        try {
            InputStreamReader ips = new InputStreamReader(System.in) ;//转换成字节

            bfrd = new BufferedReader(ips);


            while (true){
                System.out.println("Scanner:");
                String s = bfrd.readLine();
                if("e".equalsIgnoreCase(s) || "exit".equalsIgnoreCase(s)){
                    System.out.println("end");
                    break;
                }

                String s1 = s.toUpperCase();
                System.out.println(s1);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bfrd != null){

                try {
                    bfrd.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    @Test
    public void test() throws IOException {

        FileInputStream file = new FileInputStream("dbcp.txt");//字符输入流

        InputStreamReader isr = new InputStreamReader(file);
//        InputStreamReader isr1 = new InputStreamReader(file,"gbk");

        char[] c = new char[5];
        int len;
        while ((len = isr.read(c)) != -1){

            String s = new String(c,0,len);
            System.out.print(s);

        }



    }

    @Test
    public void test1() throws IOException {

        File file = new File("dbcp.txt");
        File file1 = new File("dbcp_gbl.txt");

        FileInputStream ips = new FileInputStream(file);//字符流
        FileOutputStream ops = new FileOutputStream(file1);

        InputStreamReader ipsr = new InputStreamReader(ips);
        OutputStreamWriter opsw = new OutputStreamWriter(ops);

        char[] c = new char[20];
        int len;
        while ((len = ipsr.read(c)) != -1){
            opsw.write(c);
        }

        ipsr.close();
        opsw.close();



    }


}

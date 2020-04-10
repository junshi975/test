package com.senior.java3;

import com.sun.corba.se.impl.orbutil.ObjectStreamClassUtil_1_3;
import org.hamcrest.core.StringEndsWith;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @author JUNSHI 405773808@qq.com
 * @description:
 * @create 2020-03-16 15:21
 */
public class Exer {

    @Test
    public void test2(){

        File file = new File("F:\\workspace_idea1\\JavaSenior");

        String[] list = file.list();
        for(String s : list){
            System.out.println(s);
        }

        File[] files = file.listFiles();
        for (File f : files ){

            System.out.println(f);
        }

    }

    @Test
    public void test(){

        File file1 = new File("hello.txt");
        File file2 = new File("F:\\workspace_idea1\\JavaSenior\\day08\\he.txt");

        System.out.println(file1);
        System.out.println(file2);

        File file3 = new File("F:\\workspace_idea1\\JavaSenior","\\day08");
        File file4 = new File(file3,"hi.txt");

        System.out.println(file3);
        System.out.println(file4);


    }

    @Test
    public void test1(){

        File file1 = new File("hello.txt");
        File file2 = new File("F:\\io\\hi.txt");

        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(new Date(file1.lastModified()));

        System.out.println();

        System.out.println(file2.getAbsolutePath());
        System.out.println(file2.getPath());
        System.out.println(file2.getName());
        System.out.println(file2.getParent());
        System.out.println(file2.length());
        System.out.println(file2.lastModified());



    }

    @Test
    public void test3(){

        File file = new File("hello.txt");
        File file1 = new File("F:\\io\\hi.txt");

        boolean b = file1.renameTo(file);
        System.out.println(b);


        System.out.println();

        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println(file.exists());
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.isHidden());

        System.out.println();

        File file3 = new File("F:\\io");
        System.out.println(file3.exists());
        System.out.println(file3.isDirectory());
        System.out.println(file3.isFile());
        System.out.println(file3.canRead());
        System.out.println(file3.canWrite());
        System.out.println(file3.isHidden());
    }


    @Test
    public void test4() throws IOException {

        File file = new File("hi.txt");

        if(!file.exists()){
            boolean newFile = file.createNewFile();
            System.out.println("创建成功");
        }else{
            boolean delete = file.delete();
            System.out.println("删除成功");
        }



    }
    @Test
    public void test6() throws IOException {

        File file = new File("F:\\io\\io1\\hello.txt");

        File file1 = new File("F:\\io\\io1\\haha.txt");

        if(!file1.exists()){
            boolean newFile = file1.createNewFile();
            System.out.println(newFile);

        }else{
            boolean delete = file1.delete();
            System.out.println(delete);
        }




    }
    @Test
    public void test7() throws IOException {

//        File file = new File("F:\\io\\ioexer");
//        boolean mkdirs = file.mkdirs();
//        if (mkdirs){
//            System.out.println("创建成功");
//        }else{
//            System.out.println("创建失败");
//        }

        File file = new File("F:\\io\\ioexer\\hello.txt");
        boolean newFile = file.createNewFile();
        if (newFile){
            System.out.println("创建成功" );
        }else{
            file.delete();
            System.out.println("已删除");
        }

    }

    //需求：判断E盘目录下是否有后缀名为.jpg的文件，如果有，就输出该文件名称
    @Test
    public void exer(){

        File file = new File("F:\\");
        String[] list = file.list();
        for (String s : list){

            System.out.println(s);
//            if(s.endsWith(".txt")){
//                System.out.println(s);
//            }
        }

    }
}

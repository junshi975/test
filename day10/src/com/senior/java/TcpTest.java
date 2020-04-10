package com.senior.java;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;


/**
 * //客户端发送给服务端
 *
 * @author JUNSHI 405773808@qq.com
 * @create 2020-03-18 23:38
 */
public class TcpTest {



    //客户端
    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;

        try {
            //对方ip地址
            InetAddress inet = InetAddress.getByName("127.0.0.1");
            //端口号
            socket = new Socket(inet, 8899);
            //获得字节流
            os = socket.getOutputStream();
            os.write("你好我是靓仔".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {

                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {

                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    //服务端
    @Test
    public void server() {
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;

        try {
            //连接端口号
            ss = new ServerSocket(8899);
            //接收来自客户端的socket
            socket = ss.accept();
            //读入流
            is = socket.getInputStream();

            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[5];
            int len;
            while ((len = is.read(buffer)) != -1) {
                baos.write(buffer, 0, len);

            }

            //打印
            System.out.println(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(ss != null){

                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(is != null){

                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket != null){

                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(baos != null){

                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }


}

package com.jdbc.connection;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author JUNSHI 405773808@qq.com
 * @description:
 * @create 2020-04-04 22:26
 */
public class ConnectionTest {

    @Test
    public void test1() throws SQLException {

        //方式一：
        Driver driver = new com.mysql.jdbc.Driver();


        String url = "jdbc:mysql://localhost:2001/test";
        Properties info = new Properties();

        info.setProperty("user","root");
        info.setProperty("password","20010303");


        Connection connect = driver.connect(url, info);
        System.out.println(connect);


    }

    //方式二
    @Test
    public void test2() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {

        Class clazz = Class.forName("com.mysql.jdbc.Driver");

        Driver driver = (Driver) clazz.newInstance();

        String url = "jdbc:mysql://localhost:2001/test";

        Properties info = new Properties();

        info.setProperty("user","root");
        info.setProperty("password","20010303");


        Connection connect = driver.connect(url, info);

        System.out.println(connect);


    }

    //方式三：
    @Test
    public void test3() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {

        Class clazz = Class.forName("com.mysql.jdbc.Driver");

        Driver driver = (Driver) clazz.newInstance();


        DriverManager.registerDriver(driver);

        String url = "jdbc:mysql://localhost:2001/test";

        String user = "root";

        String password = "20010303";
        Connection connection = DriverManager.getConnection(url, user, password);

        System.out.println(connection);


    }

    @Test
    public void test4() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {

        Class clazz = Class.forName("com.mysql.jdbc.Driver");


        String url = "jdbc:mysql://localhost:2001/test";

        String user = "root";

        String password = "20010303";

//        Driver driver = (Driver) clazz.newInstance();
//
//        DriverManager.registerDriver(driver);

        Connection connection = DriverManager.getConnection(url, user, password);

        System.out.println(connection);


    }

    @Test
    public void test5() throws IOException, ClassNotFoundException, SQLException {

        InputStream is = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");


        Properties properties = new Properties();
        properties.load(is);

        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driverClass = properties.getProperty("driverClass");

        Class.forName(driverClass);

        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);


    }
    @Test
    public void test6() throws IOException, ClassNotFoundException, SQLException {

        //
        InputStream resourceAsStream = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");

        Properties properties = new Properties();
        properties.load(resourceAsStream);

        String user = properties.getProperty("user");

        String password = properties.getProperty("password");

        String url = properties.getProperty("url");
        String driverClass = properties.getProperty("driverClass");

        Class.forName(driverClass);


        Connection connection = DriverManager.getConnection(url, user, password);

        System.out.println(connection);


    }


}

package com.jdbc.connection;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author JUNSHI 405773808@qq.com
 * @description:
 * @create 2020-04-05 14:53
 */
public class JDBCUtil {

    public static Connection getConnection() throws Exception {

        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");

        Properties properties = new Properties();

        properties.load(is);

        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driverClass = properties.getProperty("driverClass");

        Class.forName(driverClass);

        Connection connection = DriverManager.getConnection(url, user, password);

        return connection;

    }

    public static void clossResourse(Connection connection, Statement ps){
        try {
            if (ps != null){

                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (connection != null){

                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

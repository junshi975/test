package com.jdbc.connection;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @author JUNSHI 405773808@qq.com
 * @description:
 * @create 2020-04-05 14:58
 */
public class PrepardStatementTest {


    public void update(String sql,Object ...args) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtil.getConnection();

            preparedStatement = connection.prepareStatement(sql);

            for (int i = 0;i < args.length ;i++){
                preparedStatement.setObject(i + 1,args[i]);
            }

            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.clossResourse(connection,preparedStatement);
        }



    }

    @Test
    public void tsetUpdate()  {

        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = JDBCUtil.getConnection();

            String sql = "update customers set name = ? where id = ?";
            ps = connection.prepareStatement(sql);

            ps.setObject(1,"莫扎特");

            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.clossResourse(connection,ps);
        }


    }


}

package com.senior.exer1;

import org.junit.Test;

import java.sql.SQLOutput;
import java.util.List;

/**
 * 创建
 * DAO类的对象,
 * 分别调用其 save 、get 、update 、list 、delete方法来操作 User 对象，
 * 使用Junit 单元测试类进行测试。
 * @author JUNSHI 405773808@qq.com
 * @description:
 * @create 2020-03-16 8:09
 */
public class DAOTest {

    @Test
    public void test(){

        DAO<User> dao = new DAO<>();

        dao.save("1001",new User(1001,23,"周杰伦"));
        dao.save("1002",new User(1002,25,"周伦"));
        dao.save("1003",new User(1003,88,"杰伦"));

        dao.update("1003",new User(1003,22,"x9a0jming"));
        dao.delete("1003");
        List<User> list = dao.list();
//        System.out.println(list);

        list.forEach(System.out::println);
    }

}

package com.senior.exer1;

import java.util.*;

/**
 * 定义个泛型类DAO<T>，在其中定义一个 Map 成员变量， Map 的键
 * 为 String 类型，值为 T 类型。
 * 分别创建以下方法：
 * public void save(String id,T entity)保存 T 类型的对象到 Map成员变量中
 * public T get(String id) ：从 map 中获取 id 对应的对象
 * public void update(String id,T entity)：替换map中key为id的内容改为 entity对象
 * public List<T> list() ：返回 map 中存放的所有 T 对象
 * public void delete(String id)：删除指定 id 对象
 * @author JUNSHI 405773808@qq.com
 * @description:
 * @create 2020-03-16 8:05
 */
public class DAO<T> {

    private Map<String,T> map = new HashMap<>();

    //保存 T 类型的对象到 Map成员变量中
    public void save(String id,T entity){
        map.put(id,entity);

    }

    //从 map 中获取 id 对应的对象
    public T get(String id){

        return map.get(id);

    }

    //替换map中key为id的内容改为 entity对象
    public void update(String id,T entity){
        //修改，万一调用未找到指定的ID，就不应该去改
        if(map.containsKey(id)){

            map.put(id,entity);
        }

    }

    //返回 map 中存放的所有 T 对象
    public List<T> list(){

        //错误的
//        Collection<T> values = map.values();
//        return (List<T>) values;

        ArrayList<T> list = new ArrayList<>();
        Collection<T> values = map.values();
        for(T t : values){
            list.add(t);
        }
        return list;

    }

    //删除指定 id 对象
    public void delete(String id){

            map.remove(id);

    }

}

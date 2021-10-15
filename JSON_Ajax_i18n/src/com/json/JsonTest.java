package com.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pojo.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: jsonTest
 * @Description:
 * @Author: TianXing.Xue
 * @Date: 2021/9/15 16:04
 **/

public class JsonTest {
    //1.javaBean 和 json 的互转
    @Test
    public void test1() {
        Person person = new Person(1, "刘能");
        //创建Gson对象实例
        Gson gson = new Gson();
        //toJson()方法可以把Java对象转换成为json字符串
        String personJsonString = gson.toJson(person);
        System.out.println(personJsonString);
        //fromJson()方法把json字符串转换回Java对象
        //第一个参数是json字符串
        //第二个参数是转换回去的Java对象类型
        Person person1 = gson.fromJson(personJsonString, Person.class);
        System.out.println(person1);
    }

    @Test
    public void test2() {
        List<Person> list = new ArrayList<>();
        list.add(new Person(1, "张三"));
        list.add(new Person(2, "康师傅"));
        Gson gson = new Gson();

        //把list集合转化为json字符串
        String listJsonString = gson.toJson(list);
        System.out.println(listJsonString);
        List<Person> list1 = gson.fromJson(listJsonString, new PersonListType().getType());
        System.out.println(list1);
        Person person = list1.get(0);
        System.out.println(person);
    }

    //2.map 和 json的转换
    @Test
    public void test3() {
        Map<Integer, Person> personMap = new HashMap<>();
        personMap.put(1, new Person(1, "刘能"));
        personMap.put(2, new Person(2, "康师傅"));
        Gson gson = new Gson();
        //把Map集合转化成为json字符串
        String personMapJsonString = gson.toJson(personMap);
        System.out.println(personMapJsonString);

//        Map<Integer, Person> personMap2 = gson.fromJson(personMapJsonString, new PersonMapType().getType());
        //匿名类要{}，有方法写方法，没有方法就.getType()
        Map<Integer, Person> personMap2 = gson.fromJson(personMapJsonString, new TypeToken<HashMap<Integer, Person>>() {
        }.getType());

        System.out.println(personMap2);
        Person person = personMap2.get(1);
        System.out.println(person);
    }
}

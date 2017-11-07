package com.lanou.reflect;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.*;

/**
 * Created by dllo on 17/11/7.
 */
public class PersonTest {

    @Test
    public void test(){
        //返回离不开Class类
        //class是类的类
        Class<Person> pc1 = Person.class;
        Person p = new Person();
        Class pc2 = p.getClass();

        try {
            Class.forName("com.lanou.reflect.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        try {
            //获取类中的方法
            Method say = pc2.getDeclaredMethod("say",String.class);
            //反射调用方法
            //就相当于p.say
            say.invoke(p,"厉害啦");
//            say.setAccessible(true);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
package com.lanou.aop3;

import net.sf.cglib.proxy.Enhancer;

/**
 * Created by dllo on 17/11/7.
 */
public class TransactionProxyUtil {
    //作用: 传进去一个被代理对象,返回一个代理后的对象

    public static Object newProxyInstrance(Object target) {
        //增强类对象
        //作用:创建一个被代理对象的子类对象
        Enhancer enhancer = new Enhancer();

        Transaction transaction = new Transaction();

        UserInterceptor interceptor = new UserInterceptor(target, transaction);

        enhancer.setCallback(interceptor);
        //设置生成类(代理类的父类类型)
        enhancer.setSuperclass(target.getClass());

        return enhancer.create();
    }

}

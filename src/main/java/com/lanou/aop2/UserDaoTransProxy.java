package com.lanou.aop2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by dllo on 17/11/7.
 */
public class UserDaoTransProxy implements InvocationHandler {

    /*
    原始对象/目标对象/准备被代理的对象
     */
    private Object target;
    private Object result;

    public UserDaoTransProxy(Object target) {
        this.target = target;
    }

    //针对某个方法获取
    //获取被调用的方法名

    /**
     * @param proxy  代理后的对象
     * @param method 调用的方法
     * @param args   调用的方法的参数
     * @return 调用的方法的返回值
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //针对某个方法获取
        //获取被调用的方法名
        String methodName = method.getName();
        if (methodName.equals("insert")) {
            System.out.println("动态代理开启事务");

            //是在真实的调用某个方法
            result = method.invoke(target, args);

            System.out.println("动态代理提交事务");
            return result;
        }else {
            result = method.invoke(target,args);
        }
        return result;
    }

    public static Object getProxyInstance(Object target) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new UserDaoTransProxy(target));
    }
}

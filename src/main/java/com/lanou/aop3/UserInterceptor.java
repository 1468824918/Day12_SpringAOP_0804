package com.lanou.aop3;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by dllo on 17/11/7.
 */
public class UserInterceptor implements MethodInterceptor {
    /**
     * 目标对象
     */
    private Object target;

    /**
     * 切面类
     */
    private Transaction transaction;

    public UserInterceptor(Object target, Transaction transaction) {
        this.target = target;
        this.transaction = transaction;
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        transaction.begin();
        Object result = method.invoke(target, objects);
        transaction.commit();

        return result;
    }


}

package com.lanou.aop3;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Created by dllo on 17/11/7.
 */
public class Transaction {

    public void begin(){
        System.out.println("开启事务");
    }

    public void commit(){
        System.out.println("提交事务");
    }

    //连接点抛出异常后执行
    public void afterThrowing(){
        System.out.println("连接点抛出异常了");
    }

    //不管有没有异常都执行
    public void afterFinally(){
        System.out.println("不管有没有异常都执行");
    }
    //环绕通知
    public void around(ProceedingJoinPoint pjp){
        try {
            //就是在调用接入点方法
            System.out.println("环绕前置通知");
            pjp.proceed();
            System.out.println("环绕正常通知");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("环绕异常通知");
        }finally {
            System.out.println("环绕finally通知");
        }
    }
}

package com.lanou.aop3;

import com.lanou.aop1.TransactionProxy;
import com.lanou.aop1.UserDao;
import com.lanou.aop1.UserDaoImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dllo on 17/11/7.
 */
public class UserInterceptorTest {

    @Test
    public void test(){
        UserDao userDao = new UserDaoImpl();

        //获取代理类
        UserDao proxy = (UserDao) TransactionProxyUtil.newProxyInstrance(userDao);

        proxy.insert();
    }

}
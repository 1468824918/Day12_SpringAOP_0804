package com.lanou.aop1;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dllo on 17/11/7.
 */
public class UserDaoImplTest {
    @Test
    public void test(){
        UserDao userDao = new UserDaoImpl();
        //增加事务代理
        userDao = new TransactionProxy(userDao);
        userDao = new TimeRecordProxy(userDao);
        userDao.insert();
    }

}
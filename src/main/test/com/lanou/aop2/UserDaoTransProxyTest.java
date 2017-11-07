package com.lanou.aop2;

import com.lanou.aop1.UserDao;
import com.lanou.aop1.UserDaoImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dllo on 17/11/7.
 */
public class UserDaoTransProxyTest {
    @Test
    public void test(){
        UserDao userDao = new UserDaoImpl();
        userDao = (UserDao) UserDaoTransProxy.getProxyInstance(userDao);
        userDao.insert();
    }

}
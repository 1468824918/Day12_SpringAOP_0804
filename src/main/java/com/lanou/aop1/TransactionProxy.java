package com.lanou.aop1;

/**
 * Created by dllo on 17/11/7.
 */
public class TransactionProxy implements UserDao{
    //被代理的对象
    private UserDao userDao;

    public TransactionProxy(UserDao userDao) {
        this.userDao = userDao;
    }

    public void insert() {
        System.out.println("开启事务");
        userDao.insert();
        System.out.println("提交事务");
    }

    @Override
    public void delete() {
        System.out.println("删除");
    }

}

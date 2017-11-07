package com.lanou.aop1;

/**
 * Created by dllo on 17/11/7.
 */
public class TimeRecordProxy implements UserDao{
    private UserDao userDao;

    public TimeRecordProxy(UserDao userDao) {
        this.userDao = userDao;
    }

    public void insert() {
        System.out.println("开始计算时间");
        long start = System.currentTimeMillis();
        userDao.insert();
        long time = System.currentTimeMillis()-start;
        System.out.println("执行时间为:"+time+"ms");
    }

    @Override
    public void delete() {

    }
}

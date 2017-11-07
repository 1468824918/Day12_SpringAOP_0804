package com.lanou.aop1;

/**
 * Created by dllo on 17/11/7.
 */
public class UserDaoImpl implements UserDao{
    public void insert() {
        System.out.println("插入数据");
        try {
            Thread.sleep(52);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete() {
        System.out.println("删除数据");
        throw new NullPointerException("抛出空指针");
    }
}

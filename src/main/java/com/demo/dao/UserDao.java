package com.demo.dao;

import com.demo.entity.User;

/**
 * Created by Administrator on 2017/4/27.
 */
public interface UserDao {
    int save(User user);
    User findByUserName(String username);

}

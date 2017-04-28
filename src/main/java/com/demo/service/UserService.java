package com.demo.service;

import com.demo.entity.User;

/**
 * Created by Administrator on 2017/4/27.
 */
public interface UserService {
    void save(User user);

    User findByUsername(String username);
}

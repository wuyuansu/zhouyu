package com.demo.service.impl;

import com.demo.dao.UserDao;
import com.demo.dao.UserRoleDao;
import com.demo.entity.User;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/4/27.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserRoleDao userRoleDao;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        userDao.save(user);
        userRoleDao.setRoleByUserId(user.getId());

    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUserName(username);
    }
}

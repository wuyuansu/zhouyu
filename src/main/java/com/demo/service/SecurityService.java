package com.demo.service;

/**
 * Created by Administrator on 2017/4/27.
 */
public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);
}

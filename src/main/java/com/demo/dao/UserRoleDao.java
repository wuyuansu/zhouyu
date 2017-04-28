package com.demo.dao;

import com.demo.entity.Role;

import java.util.List;

/**
 * Created by Administrator on 2017/4/27.
 */
public interface UserRoleDao {
    List<Role> getRoleByUserId(int id);
    void setRoleByUserId(int id);
}

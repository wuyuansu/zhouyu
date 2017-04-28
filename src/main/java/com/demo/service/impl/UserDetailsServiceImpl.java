package com.demo.service.impl;

import com.demo.dao.UserDao;
import com.demo.dao.UserRoleDao;
import com.demo.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/4/27.
 */
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserDao userDao;
@Autowired
    UserRoleDao userRoleDao;


    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.demo.entity.User user=userDao.findByUserName(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
        for (Role role : userRoleDao.getRoleByUserId(user.getId())){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}


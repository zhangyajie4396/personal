package com.zyj.security;

import com.zyj.dao.UserMapper;
import com.zyj.model.User;
import com.zyj.model.UserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author: ZhangYajie
 * @Description:
 * @Date: Created in 11:57 2018/6/13
 */
@Component
public class CustomUserService implements UserDetailsService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        UserDetail user = userMapper.findByUsername(s);

        return user;
    }
}

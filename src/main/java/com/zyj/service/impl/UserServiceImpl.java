package com.zyj.service.impl;


import com.zyj.dao.UserMapper;
import com.zyj.model.User;
import com.zyj.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: ZhangYajie
 * @Description:
 * @Date: Created in 9:55 2018/6/13
 */
@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User selectById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }


    public User loadUserByUsernameAndPassword(String username, String password) {
        return userMapper.getUserByUsernameAndPassword(username, password);
    }
}

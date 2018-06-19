package com.zyj.service;

import com.zyj.model.User;

import java.util.List;

/**
 * @Author: ZhangYajie
 * @Description:
 * @Date: Created in 9:54 2018/6/13
 */
public interface IUserService {

    User selectById(Integer id);

    User loadUserByUsernameAndPassword(String username,String password);

    List<User> selectList();
}

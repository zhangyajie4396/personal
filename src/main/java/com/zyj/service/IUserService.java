package com.zyj.service;

import com.zyj.model.User;

import java.util.List;
import java.util.Map;

/**
 * @Author: ZhangYajie
 * @Description:
 * @Date: Created in 9:54 2018/6/13
 */
public interface IUserService {

    User selectById(Integer id);

    List<Map<String,Object>> selectList();

    void saveUser(User user,List<String> roleIds);

    void updateUser(User user,List<String> roleIds);
}

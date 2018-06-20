package com.zyj.service.impl;


import com.zyj.dao.RoleMapper;
import com.zyj.dao.UserMapper;
import com.zyj.dao.UserRoleMapper;
import com.zyj.model.User;
import com.zyj.model.UserDetail;
import com.zyj.model.UserRole;
import com.zyj.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @Author: ZhangYajie
 * @Description:
 * @Date: Created in 9:55 2018/6/13
 */
@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;



    @Override
    public User selectById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }


    @Override
    public List<Map<String,Object>> selectList() {
        return userMapper.selectList();
    }

    @Override
    @Transactional
    public void saveUser(User user,List<String> roleIds) {
        UserDetail userDetail = userMapper.findByUsername(user.getUsername());
        if(userDetail != null){
            throw new RuntimeException("用户名重复！");
        }

        userMapper.insertSelective(user);

        this.batchInsert(user,roleIds);
    }

    @Override
    @Transactional
    public void updateUser(User user,List<String> roleIds) {
        UserDetail userDetail = userMapper.findByUsername(user.getUsername());
        if(userDetail != null && user.getId() != userDetail.getId()  ){
            throw new RuntimeException("用户名重复！");
        }
        userMapper.updateByPrimaryKeySelective(user);

        userRoleMapper.deleteByUserId(user.getId());
        this.batchInsert(user,roleIds);

    }


    private void batchInsert(User user,List<String> roleIds){
        if(roleIds == null || roleIds.size() ==0){
            return;
        }
        List<UserRole> list = new ArrayList<>();
        for(String id : roleIds){
            UserRole userRole = new UserRole();
            userRole.setUserId(user.getId());
            userRole.setRoleId(Integer.parseInt(id));
            list.add(userRole);
        }
        userRoleMapper.batchInsert(list);
    }
}

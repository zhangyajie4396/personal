package com.zyj.service.impl;

import com.zyj.dao.RoleMapper;
import com.zyj.model.Role;
import com.zyj.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ZhangYajie
 * @Description:
 * @Date: Created in 11:52 2018/6/20
 */
@Service
public class RoleServiceImpl implements IRoleService {


   @Autowired
   private RoleMapper roleMapper;

    @Override
    public List<Role> selectAll() {
        return roleMapper.selectAll();
    }
}

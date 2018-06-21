package com.zyj.service.impl;

import com.zyj.dao.RoleMapper;
import com.zyj.dao.RoleResourceMapper;
import com.zyj.model.Role;
import com.zyj.model.RoleResource;
import com.zyj.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
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

   @Autowired
   private RoleResourceMapper roleResourceMapper;

    @Override
    public List<Role> selectAll() {
        return roleMapper.selectAll();
    }

    @Override
    @Transactional
    public void saveRole(Role role) {
        roleMapper.insertSelective(role);
    }

    @Override
    @Transactional
    public void updateRole(Role role) {
        roleMapper.updateByPrimaryKeySelective(role);
    }

    @Override
    @Transactional
    public void deleteByIds(List<Integer> ids) {
        roleMapper.deleteByIds(ids);
        roleResourceMapper.deleteByRoleIds(ids);
    }

    @Override
    @Transactional
    public void permissionConfig(List<RoleResource> list) {

        //先根据角色id删除再重新添加
        roleResourceMapper.deleteByRoleIds(Arrays.asList(list.get(0).getRoleId()));

         if(list.get(0).getResourceId()!= null){
            roleResourceMapper.batchInsert(list);
        }
    }
}

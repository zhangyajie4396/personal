package com.zyj.dao;

import com.zyj.model.Role;

import java.util.List;

public interface RoleMapper{
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    //查询所有的角色
    List<Role> selectAll();

    void deleteByIds(List<Integer> ids);

}
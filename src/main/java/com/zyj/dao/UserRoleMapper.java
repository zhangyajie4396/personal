package com.zyj.dao;

import com.zyj.model.UserRole;

import java.util.List;

public interface UserRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);

    void deleteByUserId(Integer userId);

    void batchInsert(List<UserRole> list);

    void deleteByUserIds(List<Integer> ids);
}
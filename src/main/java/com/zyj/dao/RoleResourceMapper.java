package com.zyj.dao;

import com.zyj.model.RoleResource;

import java.util.List;

public interface RoleResourceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RoleResource record);

    int insertSelective(RoleResource record);

    RoleResource selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RoleResource record);

    int updateByPrimaryKey(RoleResource record);

    void deleteByRoleIds(List<Integer> ids);

    void batchInsert(List<RoleResource> list);
}
package com.zyj.dao;

import com.zyj.model.Resource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ResourceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Resource record);

    int insertSelective(Resource record);

    Resource selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Resource record);

    int updateByPrimaryKey(Resource record);

     /*
       通过角色id查询所有资源
     * @Author: ZhangYajie
     * @Param:
     * @Description:
     * @Date: 16:04 2018/6/13 
     * @Return: 
     */
    List<Resource> findUrlByRoleNames(List<String> name);

    //获取菜单
    List<Resource> findMenuByRoleNames(List<String> name);
}
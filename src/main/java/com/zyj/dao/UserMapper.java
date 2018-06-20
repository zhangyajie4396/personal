package com.zyj.dao;

import com.zyj.model.User;
import com.zyj.model.UserDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    UserDetail findByUsername(String username);

    User getUserByUsernameAndPassword(@Param("username") String username, @Param("password")String password);

    List<Map<String,Object>> selectList();
}
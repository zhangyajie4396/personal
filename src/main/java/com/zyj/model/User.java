package com.zyj.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class User implements Serializable {
    private Integer id;

    private String username;

    private String password;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }



    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }




    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }



    public User(String username, String password) {

        this.username = username;
        this.password = password;

    }

    public User() {
    }

    public static void main(String[] args) {
//        String jsonData = "{"user":{"username":"root","password":"root"},"roleIds":["1","2"]}";
//        JSONObject jsonObject = JSONObject.parseObject(jsonData);
//        User user = JSON.parseObject(jsonObject.getString("user"), User.class);
//        List<Integer> roleIds = JSON.parseObject(jsonObject.getString("roleIds"), List.class);
//        System.out.println(user);
//        System.out.println(roleIds);

    }


}
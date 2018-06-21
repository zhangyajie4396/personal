package com.zyj.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zyj.model.User;
import com.zyj.service.IUserService;
import com.zyj.util.ResultBean;
import com.zyj.util.ResultBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Author: ZhangYajie
 * @Description:
 * @Date: Created in 10:52 2018/6/13
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("selectById")
    @ResponseBody
    public User selectById(Integer id){
        User user = userService.selectById(id);
        return user;
    }


    @RequestMapping("/selectList")
    @ResponseBody
    public ResultBean selectList(){
        List<Map<String,Object>> list = userService.selectList();
        return ResultBeanUtil.getResultBean(list);
    }

    @RequestMapping("/saveUser")
    public ResultBean saveUser(String jsonData){
        try {

            JSONObject jsonObject = JSONObject.parseObject(jsonData);
            User user = JSON.parseObject(jsonObject.getString("user"), User.class);
            List<String> roleIds = JSON.parseObject(jsonObject.getString("roleIds"), List.class);
            userService.saveUser(user,roleIds);
            return ResultBeanUtil.getSuccess();
        }catch (Exception e){
            return ResultBeanUtil.getFail(e.getMessage());
        }
    }

    @RequestMapping("/updateUser")
    public ResultBean updateUser(String jsonData){
        try {

            JSONObject jsonObject = JSONObject.parseObject(jsonData);
            User user = JSON.parseObject(jsonObject.getString("user"), User.class);
            List<String> roleIds = JSON.parseObject(jsonObject.getString("roleIds"), List.class);
            userService.updateUser(user,roleIds);
            return ResultBeanUtil.getSuccess();
        }catch (Exception e){
            return ResultBeanUtil.getFail(e.getMessage());
        }
    }


    @RequestMapping("/deleteByIds")
    public ResultBean deleteByIds(@RequestParam("ids[]") Integer[] ids){
        try {

            userService.deleteByIds(Arrays.asList(ids));
            return ResultBeanUtil.getSuccess();
        }catch (Exception e){
            return ResultBeanUtil.getFail(e.getMessage());
        }
    }

    @RequestMapping("/whoim")
    public Object whoIm()
    {
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}

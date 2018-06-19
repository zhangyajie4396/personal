package com.zyj.controller;

import com.zyj.model.User;
import com.zyj.service.IUserService;
import com.zyj.util.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
        List<User> list = userService.selectList();
        return ResultBean.getResultBean(list);
    }

    @RequestMapping("/whoim")
    public Object whoIm()
    {
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}

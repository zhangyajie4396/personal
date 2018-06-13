package com.zyj.controller;

import com.zyj.model.User;
import com.zyj.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: ZhangYajie
 * @Description:
 * @Date: Created in 10:52 2018/6/13
 */
@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("selectById")
    @ResponseBody
    public User selectById(Integer id){
        User user = userService.selectById(id);
        return user;
    }

    @RequestMapping("/whoim")
    public Object whoIm()
    {
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}

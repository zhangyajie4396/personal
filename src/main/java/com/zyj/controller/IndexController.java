package com.zyj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: ZhangYajie
 * @Description:
 * @Date: Created in 17:13 2018/6/12
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(){
        return "login";
    }

    @RequestMapping("/login-error")
    public String loginError(){
        return "error";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/index")
    public String success(){
        return "index";
    }


}

package com.zyj.controller;

import com.zyj.service.IRoleService;
import com.zyj.util.ResultBean;
import com.zyj.util.ResultBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: ZhangYajie
 * @Description:
 * @Date: Created in 11:45 2018/6/20
 */
@RestController
@RequestMapping("/admin/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @RequestMapping("selectAll")
    public ResultBean selectAll(){
        return ResultBeanUtil.getResultBean(roleService.selectAll());
    }

}

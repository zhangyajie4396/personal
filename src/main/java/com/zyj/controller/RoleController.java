package com.zyj.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zyj.model.Role;
import com.zyj.model.RoleResource;
import com.zyj.service.IRoleService;
import com.zyj.util.ResultBean;
import com.zyj.util.ResultBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

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

    @RequestMapping("/saveRole")
    public ResultBean saveRole(Role role){
        try {

            roleService.saveRole(role);
            return ResultBeanUtil.getSuccess();
        }catch (Exception e){
            return ResultBeanUtil.getFail(e.getMessage());
        }
    }

    @RequestMapping("/updateRole")
    public ResultBean updateRole(Role role){
        try {

            roleService.updateRole(role);
            return ResultBeanUtil.getSuccess();
        }catch (Exception e){
            return ResultBeanUtil.getFail(e.getMessage());
        }
    }


    @RequestMapping("/deleteByIds")
    public ResultBean deleteByIds(@RequestParam("ids[]") Integer[] ids){
        try {

            roleService.deleteByIds(Arrays.asList(ids));
            return ResultBeanUtil.getSuccess();
        }catch (Exception e){
            return ResultBeanUtil.getFail(e.getMessage());
        }
    }

    //权限配置
    @RequestMapping("/permissionConfig")
    public ResultBean permissionConfig(@RequestBody List<RoleResource> list){
        try {

            roleService.permissionConfig(list);
            return ResultBeanUtil.getSuccess();
        }catch (Exception e){
            return ResultBeanUtil.getFail(e.getMessage());
        }
    }

}

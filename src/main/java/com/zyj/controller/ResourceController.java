package com.zyj.controller;

import com.zyj.model.Resource;
import com.zyj.model.User;
import com.zyj.model.UserDetail;
import com.zyj.service.IResourceService;
import com.zyj.util.ResultBean;
import com.zyj.util.ResultBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: ZhangYajie
 * @Description:
 * @Date: Created in 11:20 2018/6/15
 */
@RestController
@RequestMapping("/admin/resource")
public class ResourceController {

    @Autowired
    private IResourceService resourceService;

    @RequestMapping("/findResource")
    public ResultBean findResource(){
        UserDetail user = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String[] roles = user.getRole().split(",");
        List<Resource> resources = resourceService.findUrlByRoleNames(Arrays.asList(roles));
        return ResultBeanUtil.getResultBean(resources);
    }

}

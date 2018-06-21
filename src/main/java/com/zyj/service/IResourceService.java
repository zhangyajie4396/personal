package com.zyj.service;


import com.zyj.model.Resource;

import java.util.List;

/**
 * @Author: ZhangYajie
 * @Description:
 * @Date: Created in 11:21 2018/6/15
 */

public interface IResourceService {

    /*
     * @Author: ZhangYajie
     * @Param: [name]
     * @Description:
     * @Date: 11:22 2018/6/15 
     * @Return: java.util.List<com.zyj.model.Resource>
     *     根据角色查询资源
       */
    List<Resource> findUrlByRoleNames(List<String> name);

    List<Resource> findAll();
}

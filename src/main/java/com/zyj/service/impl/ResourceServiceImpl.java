package com.zyj.service.impl;

import com.zyj.dao.ResourceMapper;
import com.zyj.model.Resource;
import com.zyj.service.IResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ZhangYajie
 * @Description:
 * @Date: Created in 11:23 2018/6/15
 */
@Service
public class ResourceServiceImpl implements IResourceService {

    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public List<Resource> findUrlByRoleNames(List<String> list) {
        return resourceMapper.findUrlByRoleNames(list);
    }
}

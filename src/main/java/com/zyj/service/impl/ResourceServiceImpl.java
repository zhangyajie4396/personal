package com.zyj.service.impl;

import com.zyj.dao.ResourceMapper;
import com.zyj.model.Resource;
import com.zyj.service.IResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        List<Resource> result = new ArrayList<>();
        List<Resource> resources = resourceMapper.findMenuByRoleNames(list);
        for(Resource resource : resources){
            if(resource.getPid() == null){
                List<Resource> childList = new ArrayList<Resource>();
                for(Resource child : resources){
                    if(child.getPid() == resource.getId()){
                        childList.add(child);
                    }
                }
                resource.setChildren(childList);
                result.add(resource);
            }

        }
        return result;
    }

    @Override
    public List<Resource> findAll() {
        return resourceMapper.findAll();
    }
}

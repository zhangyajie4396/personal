package com.zyj.security;

import com.zyj.dao.ResourceMapper;
import com.zyj.model.Resource;
import com.zyj.model.User;
import com.zyj.model.UserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: ZhangYajie
 * @Description:
 * @Date: Created in 15:56 2018/6/13
 */
@Component("rbacService")
public class RbacService {

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Autowired
    private ResourceMapper resourceMapper;

    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        Object principal = authentication.getPrincipal();
        boolean hasPermission = false;
        if (principal instanceof UserDetails) { //首先判断先当前用户是否是我们UserDetails对象。
            UserDetail user = (UserDetail) principal;
            String[] roles = user.getRole().split(",");

            List<Resource> resources = resourceMapper.findUrlByRoleNames(Arrays.asList(roles));

            // 注意这里不能用equal来判断，因为有些URL是有参数的，所以要用AntPathMatcher来比较
            for (Resource resource : resources) {
                String requestURI = request.getRequestURI();
                if (antPathMatcher.match(resource.getResourceUrl(), requestURI)) {
                    hasPermission = true;
                    break;
                }
            }
        }
        return hasPermission;
    }
}

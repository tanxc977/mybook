package com.xc.mybook.security.config;


import com.xc.mybook.security.dao.RoleDao;
import com.xc.mybook.security.dao.UserDao;
import com.xc.mybook.security.entity.TwRole;
import com.xc.mybook.security.entity.TwUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义用户名密码校验实现
 * 
 * @author XC
 *
 */
@Service
public class UrlUserService implements UserDetailsService {
	
    @Autowired
    UserDao userDao;
    
    @Autowired
    RoleDao roleDao;
    
    /**
     * employeeId 用户工号，在数据库中保证存储唯一
     */
    @Override
    public UserDetails loadUserByUsername(String employeeId) { //重写loadUserByUsername 方法获得 userdetails 类型用户

        TwUser user = userDao.findByEmployeeId(employeeId);
        
        if(user == null){
        	throw new UsernameNotFoundException(employeeId + " do not exist!");
        } else {
        	System.out.println(user.getPassword() + " --pw-- ");
            List<TwRole> roles = roleDao.findRoleByEmployeeId(employeeId);
            List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
            
            //写入用户的角色  ***  切记 由于框架原因 角色名称要以 ROLE_ 开头
            //源码：org.springframework.security.access.expression.SecurityExpressionRoot hasAnyRole()
            for (TwRole role : roles) {
                if (role != null && role.getRoleName() != null) {
                	SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getRoleCode());
                    grantedAuthorities.add(grantedAuthority);
                }
            }
            org.springframework.security.core.userdetails.User uu = new User(user.getUsername(), user.getPassword(), grantedAuthorities);
            return uu;
        }
    }
}
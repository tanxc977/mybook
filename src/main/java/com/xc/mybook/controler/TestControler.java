package com.xc.mybook.controler;

import com.xc.auth.mapper.UserMapper;
import com.xc.auth.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestControler {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/testmybatis")
    public List<SysUser> addUser(){
        SysUser user = new SysUser();
        user.setPassword("txc");
        user.setUsername("txc");
        int num = userMapper.addUser(user);

        return  userMapper.findAll();
    }
}

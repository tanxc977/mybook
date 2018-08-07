package com.xc.auth.mapper;


import com.xc.auth.entity.SysUser;
import com.xc.mybook.MybookApplication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MybookApplication.class)
@WebAppConfiguration   // 对于非WEB的可有可无
public class SysUserDaoTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testAddUser(){
        SysUser user = new SysUser();
        user.setUsername("jorya");
        user.setPassword("yyt");
        int num = userMapper.addUser(user);
        Assert.assertEquals(1,num);
    }
}

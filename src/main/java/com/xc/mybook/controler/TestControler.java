package com.xc.mybook.controler;

//import com.xc.mybook.auth.mapper.UserMapper;
//import com.xc.mybook.auth.entity.SysUser;
import com.xc.mybook.entity.BookStatics;
import com.xc.mybook.service.BookStaticsViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


public class TestControler {

//    @Autowired
//    private UserMapper userMapper;
//
//    @Autowired
//    private BookStaticsViewService bookStaticsViewService;
//
//    // 右边统计页
//    @RequestMapping("/book/layoutright")
//    public List<BookStatics> indexFrame(Map<String,Object> map, @PathVariable("type") String type){
//        return bookStaticsViewService.getList();
//
//    }
//
//
//    @RequestMapping("/testmybatis")
//    public List<SysUser> addUser(){
//        SysUser user = new SysUser();
//        user.setPassword("txc");
//        user.setUsername("txc");
//        int num = userMapper.addUser(user);
//
//        return  userMapper.findAll();
//    }
}

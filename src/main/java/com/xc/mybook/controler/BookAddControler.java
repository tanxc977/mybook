package com.xc.mybook.controler;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;

/**
 * controller for add new book which can be access by ROLE_ADMIN
 *
 */
@Controller
public class BookAddControler {
    /**
     * 返回新增书籍页
     * 权限要用admin ,数据库中要用ROLE_ADMIN  security 框架会自动填加ROLE_前缀
     * @return
     */
    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping("/bookdetail/addbookpage")
    public String addBook(){
        return "bookadd";
    }




}

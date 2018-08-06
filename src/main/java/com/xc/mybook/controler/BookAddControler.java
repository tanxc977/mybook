package com.xc.mybook.controler;

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

@Controller
public class BookAddControler {
    /**
     * 返回新增书籍页
     * @return
     */
    @RequestMapping("/bookdetail/addbookpage")
    public String addBook(){
        return "bookadd";
    }




}

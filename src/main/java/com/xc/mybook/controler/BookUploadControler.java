package com.xc.mybook.controler;

import com.xc.mybook.Constants;
import com.xc.mybook.dto.BookAddDto;
import com.xc.mybook.dto.JsonResult;
import com.xc.mybook.service.AddBookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;

@RestController
public class BookUploadControler {
    private static final Logger logger = LoggerFactory.getLogger(BookUploadControler.class);

    @Autowired
    private AddBookService addBookService;

    /**
     *
     * @param bookAddDto
     * @return
     */
    @RequestMapping(value = "/bookdetail/newbook/")
    public JsonResult addBook( @RequestBody BookAddDto bookAddDto){
        logger.info("book upload: " + bookAddDto.getBookName());
        JsonResult jsonResult = new JsonResult();
        logger.info("bookname: "+ bookAddDto.getBookName());
        logger.info("bookDesc: "+ bookAddDto.getBookDesc());
        logger.info("bookCatalog "+ bookAddDto.getCatagoryTag());
        if(1 != addBookService.addBookDtl(bookAddDto))
        {
            jsonResult.setCode("1");
            jsonResult.setMessage("新增书籍失败");
        }else {
            jsonResult.setCode("0");
            jsonResult.setMessage("上传成功");
        }

        return  jsonResult;
    }

    /**
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/upload/batch/", method = RequestMethod.POST)
    public JsonResult handleFileUpload(HttpServletRequest request){
        logger.info("uplaod batch");
        List<MultipartFile> files = ((MultipartHttpServletRequest) request)
                .getFiles("file");
        JsonResult jsonResult = new JsonResult();
        MultipartFile file = null;
        BufferedOutputStream stream = null;
        for (int i = 0; i < files.size(); ++i) {
            file = files.get(i);

            File fileout = getFileOut(file);
            if(!fileout.getParentFile().exists()){
                fileout.getParentFile().mkdirs();
            }

            if (!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();
                    stream = new BufferedOutputStream(new FileOutputStream(fileout));
                    stream.write(bytes);
                    stream.close();
                } catch (Exception e) {
                    stream = null;
                    jsonResult.setCode("1");
                    jsonResult.setMessage("You failed to upload " + i + " => " +"\n" + e.getMessage());

                    return jsonResult;

                }
            } else {
                jsonResult.setCode("2");
                jsonResult.setMessage("You failed to upload " + i + " => " +"\n" + "because file is empty");

                return jsonResult;
            }

        }
        jsonResult.setCode("0");
        jsonResult.setMessage("upload successful");
        return jsonResult;


    }

    private File getFileOut(MultipartFile file){
        int pos = file.getOriginalFilename().lastIndexOf('.');
        String dirname;
        if(-1 != pos){
            dirname = (file.getOriginalFilename()).substring(0,pos);
        }else{
            dirname = file.getOriginalFilename();
        }

        String filePath = Constants.uploadFilePath + File.separator + dirname;

        return new File(filePath,file.getOriginalFilename());
    }
}

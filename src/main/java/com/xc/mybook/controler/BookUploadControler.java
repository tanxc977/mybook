package com.xc.mybook.controler;

import com.xc.mybook.Constants;
import com.xc.mybook.dto.BookAddDto;
import com.xc.mybook.dto.JsonResult;
import com.xc.mybook.service.AddBookService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
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
import java.io.*;
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
        logger.info("add book {} to database;", bookAddDto.getBookName());
        JsonResult jsonResult = new JsonResult();

        if(1 != addBookService.addBookDtl(bookAddDto))
        {
            jsonResult.setCode("1");
            jsonResult.setMessage("新增书籍失败");
            logger.info("add book {} fail",bookAddDto.getBookName());
        }else {
            jsonResult.setCode("0");
            jsonResult.setMessage("上传成功");
            logger.info("add book {} success",bookAddDto.getBookName());
        }

        return  jsonResult;
    }

    /**
     * 批量上传文件
     * @param request
     * @return
     */
    @RequestMapping(value = "/upload/batch/", method = RequestMethod.POST)
    public JsonResult handleFileUpload(HttpServletRequest request){
        logger.info("upload batch file ");

        List<MultipartFile> files = ((MultipartHttpServletRequest) request)
                .getFiles("file");


        for (int i = 0; i < files.size(); ++i) {

            MultipartFile file = files.get(i);

            if (getFileOut(file).exists()){
                return packJsonResult("dupFile",i);
            }

            File fileout = getFileOut(file);

            if(!fileout.getParentFile().exists()){
                fileout.getParentFile().mkdirs();
            }

            if (!file.isEmpty()) {
                try {
                    FileUtils.copyInputStreamToFile(file.getInputStream(),fileout);
                } catch (Exception e) {
                    return packJsonResult("errorIO",i);
                }
            } else {
                return packJsonResult("emptyFile",i);
            }
            logger.info("upload file {} success",file.getOriginalFilename());
        }

        return packJsonResult("success",0);


    }

    /**
     * 包装返回结果
     * @param rtcode
     * @param fileindex
     * @return
     */
    private JsonResult packJsonResult(String rtcode, int fileindex){
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(rtcode);
        String message;
        switch (rtcode){
            case "success":
                message = "upload success!!";
                break;
            case "errorIO":
                message = "upload failed file IO error!!";
                break;
            case "emptyFile":
                message = "You failed to upload " + String.valueOf(fileindex) + " => " +"\n" + "because file is empty";
                break;
            case "dupFile":
                message = "You failed to upload " + String.valueOf(fileindex) + " => " +"\n" + "because file is allready exist";
                break;
            default:
                message = "system error";
        }
        jsonResult.setMessage(message);
        return jsonResult;
    }

    /**
     * 获取上传目的文件
     * @param file
     * @return
     */
    private File getFileOut(MultipartFile file){

        String dirname = FilenameUtils.getBaseName(file.getOriginalFilename());
        String filePath = Constants.uploadFilePath + File.separator + dirname;

        return new File(filePath,file.getOriginalFilename());
    }
}

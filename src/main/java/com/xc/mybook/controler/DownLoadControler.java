package com.xc.mybook.controler;

import com.xc.mybook.Constants;
import com.xc.mybook.entity.BookDetail;
import com.xc.mybook.service.BookDetailService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.commons.io.FilenameUtils;
import java.io.File;
import java.io.IOException;


@Controller
public class DownLoadControler extends BaseControler {

    private static final Logger logger= LoggerFactory.getLogger(DownLoadControler.class);
//    private static final Logger logger = Logger.getLogger(DownLoadControler.class);

    @Autowired
    private BookDetailService bookDetailService;

    @RequestMapping("/bookdir/{bookType}/{seqno}")
    public ResponseEntity<FileSystemResource> fileDownload(HttpServletRequest req, @PathVariable("seqno") String seqno,
                                                           @PathVariable("bookType") String bookType) {

        logger.info("down load start....");
        File downloadFile = getDownloadFile(seqno,bookType);

        try{
            return export(req, downloadFile);
        }catch (IOException e){
            return null;
        }


    }

    /**
     * 获取下载文件
     * @param seqno
     * @param bookType
     * @return
     */
    private File getDownloadFile(String seqno,String bookType){
        File downloadFile = null;
        String bookDir = Constants.localFilePath + getDownloadFileDir(seqno);
        File fileDir = new File(bookDir);

        if(!fileDir.isDirectory()){
            downloadFile = null;
        }else{
            File[] files = fileDir.listFiles();
            for (int i=0;i<files.length;i++){

                if(bookType.equalsIgnoreCase(FilenameUtils.getExtension(files[i].getName()))){
                    downloadFile = files[i];
                }
            }
        }
        logger.info("download file name: " + downloadFile);
        return downloadFile;
    }

    private String getDownloadFileDir(String seqno){

        String filePath = getFilePathStr(seqno);
        logger.info("dir name is {}",FilenameUtils.getBaseName(filePath));
        if("" != filePath){
            return FilenameUtils.getBaseName(filePath);
        }else{
            return "";
        }

    }

    private String getFilePathStr(String seqNo){

        BookDetail bookDetail = bookDetailService.getSingleBookBySeqNo(seqNo);

        if(null != bookDetail){
            return bookDetail.getFilePath();
        }else{
            return "";
        }
    }

}

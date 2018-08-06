package com.xc.mybook.controler;

import com.xc.mybook.Constants;
import com.xc.mybook.entity.BookDetail;
import com.xc.mybook.service.BookDetailService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;


@Controller
public class DownLoadControler extends BaseControler {

//    private static final org.slf4j.Logger logger= LoggerFactory.getLogger(DownLoadControler.class);
    private static final Logger logger = Logger.getLogger(DownLoadControler.class);

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

    private File getDownloadFile(String seqno,String bookType){
        File downloadFile = null;
        String bookDir = Constants.localFilePath + getFileDir(getFilePathStr(seqno));
        File fileDir = new File(bookDir);
        if(!fileDir.isDirectory()){
            downloadFile = null;
        }else{
            File[] files = fileDir.listFiles();
            for (int i=0;i<files.length;i++){
                String fileName = files[i].getName();
                String fileType = fileName.substring(fileName.lastIndexOf(".")+1);
                if (fileType.equalsIgnoreCase(bookType)){
                    downloadFile = files[i];
                }
            }
        }
        logger.info("download file name: " + downloadFile);
        return downloadFile;
    }

    private String getFileDir(String filePath){
        if(-1 !=filePath.lastIndexOf("/")){
            return filePath.substring(filePath.lastIndexOf("/")+1);
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

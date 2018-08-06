package com.xc.mybook.controler;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;


/***
 * header中的filename要用 ""，不然遇到空格类的 文件名会被截断，下到本地时的文件名不完整，并且没有后缀
 * 这个问题困扰了N天
 */
public class BaseControler {

    /***
     * 下载文件
     * @param req
     * @param file
     * @return
     * @throws IOException
     */
    public ResponseEntity<FileSystemResource> export(HttpServletRequest req, File file) throws IOException {
        if (file == null) {
            return null;
        }

        String filenameDownload = getFileNameDownload(req,file);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Content-Disposition", "attachment; filename=\"" + filenameDownload+"\"");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        return ResponseEntity
                .ok()
                .headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.parseMediaType("application/octet-stream;charset=utf-8"))
                .body(new FileSystemResource(file));
    }

    /***
     * 取下载文件名，编码为了确保中文文件名不产生乱码
     * @param req
     * @param file
     * @return
     */
    private String getFileNameDownload(HttpServletRequest req,File file){

        String userAgent = req.getHeader("user-agent").toLowerCase();

        try{
            if (userAgent.contains("msie") || userAgent.contains("like gecko") ) {
                // win10 ie edge 浏览器 和其他系统的ie
                return URLEncoder.encode(file.getName(), "UTF-8");
            } else {
                // fe
                return new String(file.getName().getBytes("UTF-8"), "iso-8859-1");
            }
        }catch (IOException e){
            e.printStackTrace();
            return "";
        }

    }

}

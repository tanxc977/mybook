package com.xc.mybook.controler;

import com.xc.mybook.Constants;
import com.xc.mybook.dto.BookDownload;
import com.xc.mybook.entity.BookDetail;
import com.xc.mybook.entity.BookStatics;
import com.xc.mybook.service.BookDetailService;
import com.xc.mybook.service.BookStaticsViewService;
import com.xc.mybook.utils.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.*;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * main Controller for book lib
 */
@Controller
public class BookMainControler {
    /**

     * return html templates

     */
    private static final Logger logger = LoggerFactory.getLogger(BookMainControler.class);


    @Autowired
    BookDetailService bookDetailService;

    @Autowired
    BookStaticsViewService bookStaticsViewService;


    @RequestMapping(value={"/","/index"})
    public String indexHtml(){
        logger.info("log on index : {}",getClass());

        return "/index";
    }


    /**
     *
     * @param map
     * @param type
     * @return
     */
    @RequestMapping("/bookindex/{type}")
    public String indexFrame(Map<String,Object> map,@PathVariable("type") String type){
        List<BookStatics> bookStaticsList = bookStaticsViewService.getList();
        map.put("type",type);
        map.put("bookStaticsList",bookStaticsList);
        return "/bookindex";
    }

    /**
     * index left booklist display
     * @param map booklistpage model
     * @return
     */
    @RequestMapping("/booklistpage/index")
    public String indexBookList(Map<String,Object> map){

        Map<String,String> mapinput= new HashMap<>();
        mapinput.put("type","index");

        map.put("totalCount",getBookListCount(mapinput));
        map.put("pageNum", new Double(Constants.pageNum).intValue());
        map.put("pageNo",1);
        map.put("type","index");

        return "/booklistpage";
    }


    /**
     * catagory by date and month
     * return book list to page list
     * @param map page model
     * @param year catagory year
     * @param month catagory month
     * @return
     */
    @RequestMapping("/booklistpage/datecata/{year}/{month}")
    public String indexBookDateCatagory(Map<String,Object> map, @PathVariable("year") String year, @PathVariable("month") String month){
        Map<String,String> mapinput= new HashMap<>();

        mapinput.put("type","datecata");
        mapinput.put("year",year);
        mapinput.put("month",month);

        map.put("totalCount",getBookListCount(mapinput));
        map.put("pageNum", new Double(Constants.pageNum).intValue());

        StringBuilder sb = new StringBuilder();
        sb.append("datecata/");
        sb.append(year);
        sb.append("/");
        sb.append(month);

        map.put("type",sb.toString());

        return "/booklistpage";
    }


    /**
     * return book list detail information according to query type:
     *          index,datacata,catagory,catagorysub,search
     *          with page number offer
     * @param map
     * @param type
     * @param pageNo
     * @return
     */
    @RequestMapping("/bookpage/{type}/{pageNum}")
    public String bookListContentCatagory(Map<String,Object> map,@PathVariable("type") String type,@PathVariable("pageNum") String pageNo){
        Map<String,String> mapInput = new HashMap<>();
        mapInput.put("type",type);
        mapInput.put("pageNo",pageNo);
        List<BookDetail> booklist = bookDetailService.getBookListDefault2(mapInput);
        map.put("bookDetailList",booklist);

        return "/bookpage2";
    }


    /**
     * return book list detail information according to query type:
     *          datecata and detail year month
     *          with page number offer
     * @param map
     * @param year
     * @param month
     * @param pageNo
     * @return
     */
    @RequestMapping("/bookpage/datecata/{year}/{month}/{pageno}")
    public String bookListDateCatagory(Map<String,Object> map,
                            @PathVariable("year") String year,@PathVariable("month") String month,
                            @PathVariable("pageno") String pageNo){
        Map<String,String> mapInput = new HashMap<>();
        mapInput.put("type","datecata");
        mapInput.put("year",year);
        mapInput.put("month",month);
        mapInput.put("pageNo",pageNo);
        List<BookDetail> booklist = bookDetailService.getBookListDefault2(mapInput);
        map.put("bookDetailList",booklist);
        return "/bookpage2";
    }


    //---------------------主分类查询展示------------------------------------------

    /***
     *
     *  return book index  according to query type:
     *          catagory  main catagory  on index page
     * @param map
     * @param main
     * @return
     */
    @RequestMapping("/bookindex/catagory/{main}")
    public String bookCatagoryContentMain(Map<String,Object> map,@PathVariable("main") String main){
        List<BookStatics> bookStaticsList = bookStaticsViewService.getList();
        StringBuilder sb = new StringBuilder();
        sb.append(Constants.listTypeCataMain);
        sb.append("/");
        sb.append(main);
        map.put("type",sb.toString());
        logger.info(sb.toString());
        map.put("bookStaticsList",bookStaticsList);
        return "/bookindex";
    }


    /***
     * 按主分类显示 书籍列表
     *
     * return book list detail information according to query type:
     *          catagory main
     *          with page number offer
     * @param map
     * @param catagoryMain
     * @return
     */
    @RequestMapping("/booklistpage/catagory/{catagoryMain}")
    public String bookListCatagoryContentMain(Map<String,Object> map, @PathVariable("catagoryMain") String catagoryMain){

        Map<String,String> mapinput= new HashMap<>();
        mapinput.put("type",Constants.listTypeCataMain);
        mapinput.put("catagoryMain",catagoryMain);

        map.put("totalCount",getBookListCount(mapinput));
        map.put("pageNum", new Double(Constants.pageNum).intValue());

        StringBuilder sb = new StringBuilder();
        sb.append("catagory/");
        sb.append(catagoryMain);
        logger.info("booklistpage type is :"+ sb.toString());
        map.put("type",sb.toString());

        return "/booklistpage";
    }


    /***
     * 按主分类显示 书籍列表 翻页
     * main catagory list page change by page number
     * @param map
     * @param main
     * @param pageNo
     * @return
     */
    @RequestMapping("/bookpage/catagory/{main}/{pageno}")
    public String bookContentListCatagoryMainPage(Map<String,Object> map,
                            @PathVariable("main") String main,
                            @PathVariable("pageno") String pageNo){
        Map<String,String> mapInput = new HashMap<>();
        mapInput.put("type",Constants.listTypeCataMain);
        mapInput.put("catagoryMain",main);
        mapInput.put("pageNo",pageNo);
        List<BookDetail> booklist = bookDetailService.getBookListDefault2(mapInput);
        map.put("bookDetailList",booklist);
        return "/bookpage2";
    }
    //------------------主分类查询结束------------------------------


    //------------------子分类查询展示------------------------------

    /***
     * 按主分类显示 书籍主页
     * @param map
     * @param main
     * @return
     */
    @RequestMapping("/bookindex/catagorysub/{main}/{sub}")
    public String bookContentListCatagorySidePage(Map<String,Object> map,@PathVariable("main") String main,
                                       @PathVariable("sub") String sub){
        List<BookStatics> bookStaticsList = bookStaticsViewService.getList();
        StringBuilder sb = new StringBuilder();
        sb.append(Constants.listTypeCataSub);
        sb.append("/");
        sb.append(main);
        sb.append("/");
        sb.append(sub);
        map.put("type",sb.toString());
        logger.info(sb.toString());
        map.put("bookStaticsList",bookStaticsList);
        return "/bookindex";
    }


    /***
     * 按主分类显示 书籍列表
     * @param map
     * @param catagoryMain
     * @return
     */
    @RequestMapping("/booklistpage/catagorysub/{catagoryMain}/{catagorySub}")
    public String mainpageSideHtml3(Map<String,Object> map, @PathVariable("catagoryMain") String catagoryMain,
                                    @PathVariable("catagorySub") String catagorySub){

        Map<String,String> mapinput= new HashMap<>();

        mapinput.put("type",Constants.listTypeCataSub);
        mapinput.put("catagoryMain",catagoryMain);
        mapinput.put("catagorySub",catagorySub);
        map.put("totalCount",getBookListCount(mapinput));
        map.put("pageNum", new Double(Constants.pageNum).intValue());

        StringBuilder sb = new StringBuilder();
        sb.append("catagorysub/");
        sb.append(catagoryMain);
        sb.append("/");
        sb.append(catagorySub);
        logger.info("booklistpage type is :"+ sb.toString());
        map.put("type",sb.toString());

        return "/booklistpage";
    }


    /***
     * 按主分类显示 书籍列表 翻页
     * @param map
     * @param main
     * @param pageNo
     * @return
     */
    @RequestMapping("/bookpage/catagorysub/{main}/{sub}/{pageno}")
    public String bookPageCataSide(Map<String,Object> map,
                                   @PathVariable("main") String main,
                                   @PathVariable("sub") String sub,
                                   @PathVariable("pageno") String pageNo){
        Map<String,String> mapInput = new HashMap<>();
        mapInput.put("type",Constants.listTypeCataSub);
        mapInput.put("catagoryMain",main);
        mapInput.put("catagorySub",sub);
        mapInput.put("pageNo",pageNo);
        List<BookDetail> booklist = bookDetailService.getBookListDefault2(mapInput);
        map.put("bookDetailList",booklist);
        return "/bookpage2";
    }
    //----------------------子分类结束---------------------------

    //----------------------明细页开始---------------------------
    @RequestMapping("/bookindex/bookdetail/{seqno}")
    public String bookDetailPage(Map<String,Object> map, @PathVariable("seqno") String seqno){
        map.put("seqno",seqno);
        return "/bookdetailindex";
    }

    //
    @RequestMapping("/bookindex/bookdetailpage/{seqno}")
    public String bookDetailPageList(Map<String,Object> map, @PathVariable("seqno") String seqno){
        List<BookStatics> bookStaticsList = bookStaticsViewService.getList();
        StringBuilder sb = new StringBuilder();
        sb.append(Constants.listTypeBookDetail);
        sb.append("/");
        sb.append(seqno);
        map.put("type",sb.toString());
        logger.info(sb.toString());
        map.put("bookStaticsList",bookStaticsList);
        return "/bookindex";
    }

    //实际明细页展示，单笔获取书籍信息
    @RequestMapping("/bookdetailpage/bookdetail/{bookid}")
    public String bookDetailSeq(Map<String,Object> map, @PathVariable("bookid") String bookid){
        BookDetail bookDetail = bookDetailService.getSingleBookBySeqNo(bookid);
        String filePath = bookDetail.getFilePath();
        List<BookDownload> fileList = new ArrayList<BookDownload>();

        if(filePath.trim().length() != 0 && filePath != null){

            String filepathprefix =Config.get("filepath");

            String dirName = filePath.substring(filePath.lastIndexOf("/")+1);

            File filepath = new File(Constants.localFilePath+"\\"+dirName);

            if(!filepath.isDirectory()){
                map.put("fileList",fileList);
            }else if(filepath.isDirectory()){
                String[] filesublist = filepath.list();
                for(int i=0;i<filesublist.length;i++){
                    BookDownload bookDownload = new BookDownload();

                    File filesub = new File(filepath+"\\"+filesublist[i]);
                    String filename = filesub.getName();
                    String bookType = filename.substring(filename.lastIndexOf(".")+1);
                    String bookName = filename.substring(0,filename.lastIndexOf("."));

                    StringBuilder sb = new StringBuilder();
                    sb.append(filepathprefix);
                    sb.append("/");
                    sb.append(bookType);
                    sb.append("/");
                    sb.append(bookid);

                    bookDownload.setBookName(bookName);
                    bookDownload.setBookType(bookType);
                    bookDownload.setBookUrl(sb.toString());

                    fileList.add(bookDownload);
                }
            }

            map.put("fileList",fileList);
        }

        map.put("book",bookDetail);
        return "/bookdetailpage";
    }
    //-------------明细页结束--------------------




    //---------------搜索-----------------------
    @RequestMapping("/booklist/search")
    public String bookSearch(Map<String,Object> map, @RequestBody String searchBook){
        Map<String,String> inquireCondition= new HashMap<>();

        inquireCondition.put("type",Constants.listSearch);
        String searchBookLocal = "";
        try {
            searchBookLocal = URLDecoder.decode(searchBook.split("=")[1],"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            searchBookLocal = searchBook;
        }
        inquireCondition.put("searchBook", searchBookLocal);

        map.put("totalCount",getBookListCount(inquireCondition));
        map.put("pageNum", new Double(Constants.pageNum).intValue());

        StringBuilder sb = new StringBuilder();
        sb.append("search/");
        sb.append(searchBookLocal);
        logger.info("booklistpage type is :"+ sb.toString());
        map.put("type",sb.toString());

        return "/booklistpage";
    }



    @RequestMapping("/bookpage/search/{bookSearch}/{pageNo}")
    public String bookSearchList(Map<String,Object> map,@PathVariable("bookSearch") String bookSearch,
                                 @PathVariable("pageNo") String pageNo){
        Map<String,String> mapInput = new HashMap<>();
        mapInput.put("type",Constants.listSearch);
        mapInput.put("searchBook",bookSearch);
        mapInput.put("pageNo",pageNo);
        logger.info("bookSearchList para:" + mapInput.toString());
        List<BookDetail> booklist = bookDetailService.getBookListDefault2(mapInput);
        map.put("bookDetailList",booklist);
        return "/bookpage2";
    }
    //---------------搜索结束-----------------------

    //子函数

    private Integer getBookListCount(Map<String,String> mapinput){
        return bookDetailService.getBookListCount(mapinput);
    }



    //--------------------------Deprecated---------------------------------------------------------
//    /***
//     * 文件下载
//     * @param filepath
//     * @return
//     */
//    @Deprecated
//    @RequestMapping(value = "/bookdir/{bookType}/{filepath}",produces = "application/json;charset=utf-8")
/*    public void bookDownload(HttpServletRequest req, HttpServletResponse res, @PathVariable("filepath") String filepath,
                             @PathVariable("bookType") String bookType){

        String userAgent = req.getHeader("user-agent").toLowerCase();


        byte[] buff = new byte[1024];
        BufferedInputStream bis = null;
        OutputStream os = null;

        try {
            String fileDirName = URLDecoder.decode(filepath,"utf-8");
            File downloadFile = null;
            String bookDir = Constants.localFilePath + fileDirName;
            File fileDir = new File(bookDir);
            if(!fileDir.isDirectory()){
                throw new IOException();
            }else if(fileDir.isDirectory()){
                File[] files = fileDir.listFiles();
                for (int i=0;i<files.length;i++){
                    String fileName = files[i].getName();
                    String fileType = fileName.substring(fileName.lastIndexOf(".")+1);
                    if (fileType.equalsIgnoreCase(bookType)){
                        downloadFile = files[i];
                    }
                }
            }


            res.reset();
            res.setCharacterEncoding("utf-8");

            String filenameDownload = null;
            if (userAgent.contains("msie") || userAgent.contains("like gecko") ) {
                // win10 ie edge 浏览器 和其他系统的ie
                filenameDownload = URLEncoder.encode(downloadFile.getName(), "UTF-8");
            } else {
                // fe
                filenameDownload = new String(downloadFile.getName().getBytes("UTF-8"), "iso-8859-1");
            }

            String fileName = filenameDownload.substring(0,filenameDownload.lastIndexOf("."));
            String fileType = filenameDownload.substring(filenameDownload.lastIndexOf(".")+1);

            res.addHeader("Content-Disposition", "attachment;fileName=" + fileName + "." + fileType);
            res.addHeader("Content-Length",Long.toString(downloadFile.length()));
            res.setContentType("application/octet-stream");
            os = res.getOutputStream();

            bis = new BufferedInputStream(FileUtils.openInputStream(downloadFile));
            int i = bis.read(buff);
            while(i!=-1){
                os.write(buff,0,buff.length);
                os.flush();
                i = bis.read(buff);
            }

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(bis != null){
                try {
                    bis.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }

    }*/

}

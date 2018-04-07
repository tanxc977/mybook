package com.xc.mybook.controler;

import com.xc.mybook.Constants;
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

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BookMainControler {
    /**

     * 返回html模板.

     */
    private static final Logger logger = LoggerFactory.getLogger(BookMainControler.class);

    @Autowired
    BookDetailService bookDetailService;

    @Autowired
    BookStaticsViewService bookStaticsViewService;

    @RequestMapping("/")
    public String indexHtml(){
        return "/index";
    }

//    主页显示
    @RequestMapping("/bookindex/{type}")
    public String bookindexHtml(Map<String,Object> map,@PathVariable("type") String type){
        List<BookStatics> bookStaticsList = bookStaticsViewService.getList();
        map.put("type",type);
        map.put("bookStaticsList",bookStaticsList);
        return "/bookindex";
    }

//    主页显示
    @RequestMapping("/booklistpage/index")
    public String mainpageHtml2(Map<String,Object> map){

        Map<String,String> mapinput= new HashMap<>();
        mapinput.put("type","index");

        Integer totalCount = bookDetailService.getBookListCount(mapinput);

        map.put("totalCount",totalCount);
        map.put("pageNum", new Double(Constants.pageNum).intValue());
        map.put("pageNo",1);
        map.put("type","index");

        return "/booklistpage";
    }



//   按日期显示
    @RequestMapping("/booklistpage/datecata/{year}/{month}")
    public String mainpageHtml3(Map<String,Object> map, @PathVariable("year") String year, @PathVariable("month") String month){
        Map<String,String> mapinput= new HashMap<>();

        mapinput.put("type","datecata");
        mapinput.put("year",year);
        mapinput.put("month",month);

        Integer totalCount = bookDetailService.getBookListCount(mapinput);
        map.put("totalCount",totalCount);
        map.put("pageNum", new Double(Constants.pageNum).intValue());

        StringBuilder sb = new StringBuilder();
        sb.append("datecata/");
        sb.append(year);
        sb.append("/");
        sb.append(month);

        map.put("type",sb.toString());

        return "/booklistpage";
    }


    @RequestMapping("/bookpage/{type}/{pageNum}")
    public String bookPage2(Map<String,Object> map,@PathVariable("type") String type,@PathVariable("pageNum") String pageNo){
        Map<String,String> mapInput = new HashMap<>();
        mapInput.put("type",type);
        mapInput.put("pageNo",pageNo);
        List<BookDetail> booklist = bookDetailService.getBookListDefault2(mapInput);
        map.put("bookDetailList",booklist);

        return "/bookpage2";
    }

//    按日期显示
    @RequestMapping("/bookpage/datecata/{year}/{month}/{pageno}")
    public String bookPage2(Map<String,Object> map,
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
     * 按主分类显示 书籍主页
     * @param map
     * @param main
     * @return
     */
    @RequestMapping("/bookindex/catagory/{main}")
    public String bookCatagoryHtml(Map<String,Object> map,@PathVariable("main") String main){
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
     * @param map
     * @param catagoryMain
     * @return
     */
    @RequestMapping("/booklistpage/catagory/{catagoryMain}")
    public String mainpageHtml3(Map<String,Object> map, @PathVariable("catagoryMain") String catagoryMain){
        Map<String,String> mapinput= new HashMap<>();

        mapinput.put("type",Constants.listTypeCataMain);
        mapinput.put("catagoryMain",catagoryMain);

        Integer totalCount = bookDetailService.getBookListCount(mapinput);
        map.put("totalCount",totalCount);
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
     * @param map
     * @param main
     * @param pageNo
     * @return
     */
    @RequestMapping("/bookpage/catagory/{main}/{pageno}")
    public String bookPageCataMain(Map<String,Object> map,
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
    public String bookCatagorySideHtml(Map<String,Object> map,@PathVariable("main") String main,
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
        Integer totalCount = bookDetailService.getBookListCount(mapinput);
        map.put("totalCount",totalCount);
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
    @RequestMapping("/bookdetailpage/bookdetail/{seqno}")
    public String bookDetailSeq(Map<String,Object> map, @PathVariable("seqno") String seqno){
        BookDetail bookDetail = bookDetailService.getSingleBookBySeqNo(seqno);
        String filePath = bookDetail.getFilePath();

        if(filePath.trim().length() != 0 && filePath != null){
            StringBuilder sb = new StringBuilder();
            sb.append(Config.getInstance().get("filepath"));
            sb.append(filePath.substring(filePath.indexOf("ebook")+5));
            sb.append("大漠苍狼 - 南派三叔.epub");
            map.put("fileList",sb.toString());
        }

        map.put("book",bookDetail);
        return "/bookdetailpage";
    }
    //-------------明细页结束--------------------


    //---------------搜索-----------------------
    @RequestMapping("/booklist/search")
    public String bookSearch(Map<String,Object> map, @RequestBody String searchBook){
        Map<String,String> mapinput= new HashMap<>();

        mapinput.put("type",Constants.listSearch);
        String searchBookLocal = null;
        try {
            searchBookLocal = URLDecoder.decode(searchBook.split("=")[1],"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            searchBookLocal = searchBook;
        }
        mapinput.put("searchBook", searchBookLocal);
        Integer totalCount = bookDetailService.getBookListCount(mapinput);
        map.put("totalCount",totalCount);
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
}

package com.xc.mybook;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Constants variable
 */
public class Constants {

    public final static List<String> tagList = Arrays.asList("军事科学·历史地理","多看专区","kindle人全站打包",
            "中亚官方合集资源下载","畅销小说","官场商战·人生百态","人物传记·旅行见闻","其他站点合集资源下载",
            "武侠玄幻·穿越言情","电纸书工具","现代文学·励志鸡汤","原版书籍","工具书",
            "网络小说","生活养生·运动健身","kindle漫画","杂志·期刊","office办公","科幻奇幻·西方异世",
            "历史架空·热血战争","悬疑恐怖·穿越重生","官场商战·阴谋阳谋","武侠玄幻·仙侠修真","合集资源",
            "书评","甲骨文系列丛书","轻小说");
    public final static Map<String,String> tagMap = new HashMap<String,String>(){
        {
            put(tagList.get(0),"CXXS,JSKX");
            put(tagList.get(1),"DKZQ,DKZQ");
            put(tagList.get(2),"HJZY,KRDB");
            put(tagList.get(3),"HJZY,ZYHJ");
            put(tagList.get(4),"CXXS,CXXS");
            put(tagList.get(5),"CXXS,GCSZ");
            put(tagList.get(6),"CXXS,RWZJ");
            put(tagList.get(7),"HJZY,QTHJ");
            put(tagList.get(8),"WLXS,CYYQ");
            put(tagList.get(9),"SJGJ,SJGJ");
            put(tagList.get(10),"CXXS,XDWX");
            put(tagList.get(11),"YBSJ,YBSJ");
            put(tagList.get(12),"GJS,GJS");
            put(tagList.get(13),"WLXSWLXS");
            put(tagList.get(14),"CXXS,SHYS");
            put(tagList.get(15),"MH,MH");
            put(tagList.get(16),"ZZQK,ZZQK");
            put(tagList.get(17),"GJS,OFBG");
            put(tagList.get(18),"WLXS,KHQH");
            put(tagList.get(19),"WLXS,LSJK");
            put(tagList.get(20),"WLXS,XQKB");
            put(tagList.get(21),"CXXS,GCSZ");
            put(tagList.get(22),"WLXS,XXXZ");
            put(tagList.get(23),"HJZY,HJZY");
            put(tagList.get(24),"SP,SP");
            put(tagList.get(25),"HJZY,JGW");
            put(tagList.get(26),"QXS,QXS");
        }
    };

    public static final Double pageNum = 10.00;

    public static final Integer subContentLength = 162;
    public static final String commonSqlPrefix = "select seqno,catagory_tag,update_date,book_url,book_name,book_desc," +
            "enter_date,down_url,down_pwd,image_path,file_path,download_flag,catagory_tag_main,catagory_tag_side," +
            "update_date_yyyy,update_date_mm,update_date_dd,book_star from book_detail ";
    public static final String bookDetailTable = "book_detail";
    public static final String bookStaticsViewInquireSql = "select update_date_yyyy,update_date_mm,count from " +
            "book_statics_view ORDER BY update_date_yyyy DESC , update_date_mm DESC";

    public static final String listTypeIndex = "index";
    public static final String listTypeDate = "datecata";
    public static final String listTypeCataMain = "catagory";
    public static final String listTypeCataSub = "catagorysub";
    public static final String listTypeBookDetail ="bookdetail";
    public static final String listSearch = "search";

    public static final String localFilePath = "H:\\mbook\\ebook\\";
    public static final String uploadFilePath = "H:\\mbook\\upload\\";
    public static final String uploadFilePath2 ="H:" + File.separator + "mbook" + File.separator + "upload" + File.separator;

    //以下的已转移到config文件中
    public static final String imagePath = "/bookimage";
    public static final String filePath = "/bookdir";




}

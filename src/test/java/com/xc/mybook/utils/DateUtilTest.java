package com.xc.mybook.utils;

import com.xc.mybook.MybookApplication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.xc.mybook.utils.DateUtils;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MybookApplication.class)
public class DateUtilTest {

    @Test
    public void testDate(){
        System.out.println("timestamp is: " + DateUtils.getSqlTimeStamp());
    }

    @Test
    public void testMonth(){
        System.out.println("month is :" + DateUtils.getMonth());
        Assert.assertEquals("8",String.valueOf(DateUtils.getMonth()));
    }

    @Test
    public void testDay(){
        System.out.println("day is :" + DateUtils.getDay());
    }

    @Test
    public void testYMD(){
        System.out.println("yymmdd is: "+ DateUtils.getYYYYMMDD());
        System.out.println("date is : "+ new Date().toString());

    }

}

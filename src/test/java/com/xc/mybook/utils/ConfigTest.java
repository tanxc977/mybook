package com.xc.mybook.utils;

import com.xc.mybook.MybookApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MybookApplication.class)
public class ConfigTest {
//    private static final Logger logger = LoggerFactory.getLogger(ConfigTest.class);


    @Test
    public void configGetTest(){
//        logger.info("config get test in ");
        System.out.println(Config.get("imagePath"));
    }

}

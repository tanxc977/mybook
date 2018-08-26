package com.xc.mybook.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * get conf.properties in memory
 * config tool class
 */
public class Config {
    private static final Logger logger = LoggerFactory.getLogger(Config.class);
    private static Config config = null;
    private static Properties properties = null;

    static {
        properties = new Properties();
        try {
            properties.load(Config.class.getResourceAsStream("/conf/conf.properties"));
        } catch (Exception e) {
            logger.info("can not load properties files");
            e.printStackTrace();
        }
    }

    public static Config getInstance(){
        if(config != null){
            return config;
        }else{
            return new Config();
        }
    }

    public static String get(String key){
        return (String) properties.get(key);
    }
}

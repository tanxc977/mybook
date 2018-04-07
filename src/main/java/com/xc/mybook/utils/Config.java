package com.xc.mybook.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;

public class Config {
    private static final Logger logger = LoggerFactory.getLogger(Config.class);
    private static Config config = null;
    private Properties properties = null;

    private Config() {
        properties = new Properties();
        try {
            properties.load(getClass().getResourceAsStream("/conf/conf.properties"));
        } catch (IOException e) {
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

    public String get(String key){
        return (String) properties.get(key);
    }
}

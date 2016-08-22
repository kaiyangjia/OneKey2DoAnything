package com.jiakaiyang.onekey2doanything.utils;

import android.content.res.AssetManager;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 本地的local.properties 的相关操作
 */

public class PropertiesUtils {

    public static String readLocalProperties(AssetManager assetManager, String key){
        Properties properties = new Properties();
        try {
            InputStream inputStream = assetManager.open("local.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        if(properties != null
            && properties.containsKey(key)){
            return properties.getProperty(key);
        }
        return null;
    }
}

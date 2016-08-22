package com.jiakaiyang.onekey2doanything.utils;

import org.junit.Test;

import static junit.framework.Assert.assertTrue;

/**
 * Created by jia on 16/8/22.
 */

public class PropertiesUtilsUnitTest {


    @Test
    public void getLocalPropertiesTest(){
        String result = PropertiesUtils.readLocalProperties(FeedbackActivity.class, "leanCloudAppId");
        assertTrue(result != null);
    }
}

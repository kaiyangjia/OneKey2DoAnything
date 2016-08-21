package com.jiakaiyang.onekey2doanything.data.entity;

import android.content.Intent;
import android.graphics.Bitmap;

/**
 * 快捷方式的实体类，用来描述一个快捷方式
 */
public class Shortcut {
    private String name;

    private Long version;

    private Bitmap iconBitmap;

    private int iconResId;

    private String iconURL;

    private Intent intent;
}

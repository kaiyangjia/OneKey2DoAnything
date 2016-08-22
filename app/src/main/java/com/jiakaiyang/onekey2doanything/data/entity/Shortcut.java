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


    public static class Builder{
        private Shortcut shortcut;

        public Builder() {
            shortcut = new Shortcut();
        }

        public Shortcut build(){
            return shortcut;
        }

        public Builder name(String name){
            shortcut.name = name;
            return this;
        }

        public Builder version(Long version){
            shortcut.version = version;
            return this;
        }

        public Builder icon(Bitmap icon){
            shortcut.iconBitmap = icon;
            return this;
        }

        public Builder icon(int iconResId){
            shortcut.iconResId = iconResId;
            return this;
        }

        public Builder icon(String iconURL){
            shortcut.iconURL = iconURL;
            return this;
        }

        public Builder intent(Intent intent){
            shortcut.intent = intent;
            return this;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Bitmap getIconBitmap() {
        return iconBitmap;
    }

    public void setIconBitmap(Bitmap iconBitmap) {
        this.iconBitmap = iconBitmap;
    }

    public int getIconResId() {
        return iconResId;
    }

    public void setIconResId(int iconResId) {
        this.iconResId = iconResId;
    }

    public String getIconURL() {
        return iconURL;
    }

    public void setIconURL(String iconURL) {
        this.iconURL = iconURL;
    }

    public Intent getIntent() {
        return intent;
    }

    public void setIntent(Intent intent) {
        this.intent = intent;
    }
}

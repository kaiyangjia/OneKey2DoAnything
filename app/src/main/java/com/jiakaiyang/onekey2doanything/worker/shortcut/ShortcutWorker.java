package com.jiakaiyang.onekey2doanything.worker.shortcut;

import android.content.Context;

import com.jiakaiyang.onekey2doanything.data.entity.Shortcut;
import com.jiakaiyang.onekey2doanything.utils.ShortcutUtils;

/**
 *  提供快捷方式管理一系列的服务
 */
public class ShortcutWorker {

    public static void createShortcut(Context context, Shortcut shortcut){
        ShortcutUtils.createShortcut(context
                , shortcut.getIconResId(), shortcut.getName(), shortcut.getIntent());
    }
}

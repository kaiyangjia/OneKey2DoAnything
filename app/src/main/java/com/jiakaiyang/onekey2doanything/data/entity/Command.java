package com.jiakaiyang.onekey2doanything.data.entity;

/**
 * 指令实体类,app最基本的概念,每点击一个快捷方式就是让系统去执行一个指令
 */

public class Command {
    //打给某人
    public static int TYPE_CALL;
    //导航到某地
    public static int TYPE_NAVI;


    //未设置过,默认未该状态
    public static int STATE_NOT_SETTLE;

    //已经设置过的状态
    public static int STATE_SETTLE;

    private int id;

    private String name;

    private String describe;

    private int type;

    private Shortcut shortcut;

    //状态,已经设置过,未设置过等
    private int state;
}

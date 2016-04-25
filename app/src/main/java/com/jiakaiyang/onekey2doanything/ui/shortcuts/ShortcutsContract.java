package com.jiakaiyang.onekey2doanything.ui.shortcuts;

import com.jiakaiyang.onekey2doanything.data.entity.Shortcut;
import com.jiakaiyang.onekey2doanything.ui.base.BasePresenter;
import com.jiakaiyang.onekey2doanything.ui.base.BaseView;

import java.util.List;

/**
 * 用于view 和 presenter 之间交互的一组接口,这些借口正是业务逻辑的抽象
 */
public interface ShortcutsContract {

    interface View extends BaseView<Presenter> {

        /**
         * 显示所有快捷方式列表
         * @param shortcuts
         */
        void showShortcuts(List<Shortcut> shortcuts);

        /**
         * 显示没有任何快捷方式的ui
         */
        void showNoShortcuts();

        /**
         * 显示添加快捷方式的ui
         */
        void showAddShortcut();

        /**
         * 显示某一个快捷方式的详情
         */
        void showShortcutDetailUI(String shortcutId);

        /**
         * 显示加载错误的ui
         */
        void showLoadingShortcutError();

        /**
         * 显示添加新的快捷方式成功的提示
         */
        void showAddSuccessfulMessage();

        /**
         * 显示添加快捷方式失败的提示
         * @param errorMessage 添加失败的描述信息
         */
        void showAddFailedMessage(String errorMessage);

        /**
         * 该页面是否处于激活(已经初始化)的状态
         * @return ture 表示该页面已经激活
         */
        boolean isActive();
    }

    interface Presenter extends BasePresenter {

    }
}

package com.jiakaiyang.onekey2doanything.ui.edit;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;

import com.jiakaiyang.onekey2doanything.ui.base.BasePresenter;
import com.jiakaiyang.onekey2doanything.ui.base.BaseView;

/**
 * Edit页面的接口协议
 */

public interface EditCallContract {
    interface View extends BaseView<Presenter> {
        public Context getViewContext();

        public String getName();

        public String getDesc();

        public String getNumber();

        public void setName(String name);

        public void setDesc(String desc);

        public void setNumber(String number);

        public void setAvatarImage(Bitmap avatarView);

        public void hideAvatarText();

        public void showAvatarText();

        //打开选择从相机或者相册添加照片的dialog
        public void openImageTypeSelectDialog();
    }


    interface Presenter extends BasePresenter {
        public void onAvatarImageClicked();

        public void onCameraButtonClicked();

        public void onGalleryButtonClicked();

        public void createShortcut();

        public void setAvatar(Uri uri);

    }
}

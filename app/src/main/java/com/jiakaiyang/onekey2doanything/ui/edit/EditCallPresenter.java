package com.jiakaiyang.onekey2doanything.ui.edit;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;

import com.jiakaiyang.onekey2doanything.R;
import com.jiakaiyang.onekey2doanything.data.entity.Shortcut;
import com.jiakaiyang.onekey2doanything.worker.shortcut.ShortcutWorker;

import java.io.IOException;

/**
 * Presenter of Edit Call
 */

public class EditCallPresenter implements EditCallContract.Presenter{
    private EditCallContract.View mEditCallView;

    public EditCallPresenter(EditCallContract.View mEditCallView) {
        this.mEditCallView = mEditCallView;
        mEditCallView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void onAvatarImageClicked() {
        mEditCallView.openImageTypeSelectDialog();
    }

    @Override
    public void onCameraButtonClicked() {
        ((EditActivity)mEditCallView.getViewContext()).openCarema();
    }

    @Override
    public void onGalleryButtonClicked() {
        ((EditActivity)mEditCallView.getViewContext()).openGallery();
    }

    @Override
    public void onBtnDoneClicked() {
        createShortcut();
    }

    public void createShortcut() {
        String name = mEditCallView.getName();
        String number = mEditCallView.getNumber();
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));

        Shortcut.Builder builder = new Shortcut.Builder();
        Shortcut shortcut = builder.name(name)
                .icon(R.mipmap.ic_launcher)
                .intent(intent)
                .build();

        ShortcutWorker.createShortcut(mEditCallView.getViewContext(), shortcut);
        Snackbar.make(((AppCompatActivity)mEditCallView.getViewContext()).findViewById(android.R.id.content)
                , mEditCallView.getViewContext().getResources().getString(R.string.shortcut_create_success)
                , Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void setAvatar(Uri uri) {
        try {
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(
                    mEditCallView.getViewContext().getContentResolver(), uri);
            mEditCallView.setAvatarImage(bitmap);
            mEditCallView.hideAvatarText();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

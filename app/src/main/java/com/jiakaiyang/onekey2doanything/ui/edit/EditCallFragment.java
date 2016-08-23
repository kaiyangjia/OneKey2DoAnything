package com.jiakaiyang.onekey2doanything.ui.edit;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.FragmentTransaction;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.google.common.base.Strings;
import com.jiakaiyang.onekey2doanything.R;
import com.jiakaiyang.onekey2doanything.ui.base.BaseFragment;
import com.jiakaiyang.onekey2doanything.ui.base.OnPageIndexClickListener;
import com.jiakaiyang.onekey2doanything.ui.common.fragment.ImageTypeSelectFragment;
import com.jiakaiyang.onekey2doanything.ui.common.views.EditItemEditTextView;
import com.jiakaiyang.onekey2doanything.utils.MediaUtils;

import static android.provider.MediaStore.Files.FileColumns.MEDIA_TYPE_IMAGE;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * 用于编辑已经添加的command的页面
 */

public class EditCallFragment extends BaseFragment
        implements EditCallContract.View
        , View.OnClickListener
        , RadioGroup.OnCheckedChangeListener{
    public static final String PAGE_TAG = "EditPage";

    private OnPageIndexClickListener onPageIndexClickListener;

    private EditCallContract.Presenter mPresenter;

    private Button btnPre;

    private Button btnDone;

    private EditText mNameValueView, mDescValueView, mNumberValueView;



    public static EditCallFragment newInstance(){
        return new EditCallFragment();
    }


    @Override
    public void initView(){
        EditItemEditTextView editItemEditTextViewNumber = (EditItemEditTextView) rootView.findViewById(R.id.item_edit_number);
        EditItemEditTextView editItemEditTextViewName = (EditItemEditTextView) rootView.findViewById(R.id.item_edit_name);
        EditItemEditTextView editItemEditTextViewDesc = (EditItemEditTextView) rootView.findViewById(R.id.item_edit_desc);

        EditText editText = editItemEditTextViewNumber.getmValueView();
        editText.setInputType(InputType.TYPE_CLASS_NUMBER);

        btnPre = (Button) rootView.findViewById(R.id.btn_pre);
        btnPre.setOnClickListener(this);

        btnDone = (Button) rootView.findViewById(R.id.btn_done);
        btnDone.setOnClickListener(this);

        mNameValueView = editItemEditTextViewName.getmValueView();
        mDescValueView = editItemEditTextViewDesc.getmValueView();
        mNumberValueView = editItemEditTextViewNumber.getmValueView();

        rootView.findViewById(R.id.avatar).setOnClickListener(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void setPresenter(EditCallContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    public OnPageIndexClickListener getOnPageIndexClickListener() {
        return onPageIndexClickListener;
    }

    public void setOnPageIndexClickListener(OnPageIndexClickListener onPageIndexClickListener) {
        this.onPageIndexClickListener = onPageIndexClickListener;
    }

    @Override
    public int getRootViewRes() {
        return R.layout.command_edit_call_frg;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_pre:
                onPageIndexClickListener.onPreClick(PAGE_TAG);
                break;
            case R.id.btn_done:
                if(checkInput()){
                    mPresenter.onBtnDoneClicked();
                }
                break;
            case R.id.avatar:
                mPresenter.onAvatarImageClicked();
                break;
        }
    }

    /**
     * 检查当前输入的内容是否合法
     * @return
     */
    private boolean checkInput(){
        if(Strings.isNullOrEmpty(getName())){
            mNameValueView.setError(getResources().getString(R.string.name_cant_null));
            return false;
        }

        if(Strings.isNullOrEmpty(getNumber())){
            mNumberValueView.setError(getResources().getString(R.string.number_cant_null));
            return false;
        }

        return true;
    }

    @Override
    public Context getViewContext() {
        return getActivity();
    }

    @Override
    public String getName() {
        return mNameValueView.getText().toString();
    }

    @Override
    public String getDesc() {
        return mDescValueView.getText().toString();
    }

    @Override
    public String getNumber() {
        return mNumberValueView.getText().toString();
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public void setDesc(String desc) {

    }

    @Override
    public void setNumber(String number) {

    }

    @Override
    public void setAvatarImage(Bitmap avatarView) {
        ((ImageView)rootView.findViewById(R.id.add_avatar)).setImageBitmap(avatarView);
    }

    @Override
    public void hideAvatarText() {
        rootView.findViewById(R.id.avatar_text).setVisibility(View.GONE);
    }

    @Override
    public void showAvatarText(){
        rootView.findViewById(R.id.avatar_text).setVisibility(View.VISIBLE);
    }

    @Override
    public void openImageTypeSelectDialog() {
        ImageTypeSelectFragment fragment = ImageTypeSelectFragment.newInstance();
        fragment.getRadioGroup().setOnCheckedChangeListener(this);
        fragment.show(getChildFragmentManager(), "imageSelect");
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (group.getId()){
            case ImageTypeSelectFragment.radioGroupId:
                switch (checkedId){
                    case ImageTypeSelectFragment.radioButtonCameraId:
                        mPresenter.onCameraButtonClicked();
                        break;
                    case ImageTypeSelectFragment.radioButtonGalleryId:
                        mPresenter.onGalleryButtonClicked();
                        break;
                }
                break;
        }
    }
}

package com.jiakaiyang.onekey2doanything.ui.shortcuts;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.jiakaiyang.onekey2doanything.R;
import com.jiakaiyang.onekey2doanything.ui.base.BaseActivity;
import com.jiakaiyang.onekey2doanything.ui.edit.EditActivity;
import com.jiakaiyang.onekey2doanything.ui.feedback.FeedbackFragment;
import com.jiakaiyang.onekey2doanything.ui.help.HelpFragment;
import com.jiakaiyang.onekey2doanything.utils.ActivityUtils;
import com.jiakaiyang.onekey2doanything.utils.Constants;



public class ShortcutsActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout mDrawerLayout;

    private static final String TAG_FRAGMENT_MAIN = "main";
    private static final String TAG_FRAGMENT_FEEDBACK = "feedback";
    private static final String TAG_FRAGMENT_HELP= "help";

    private Menu naviMenu;

    private FloatingActionButton fab;

    private final int[] menuIds = {
            R.id.drawer_menu_setting,
            R.id.drawer_menu_main,
            R.id.drawer_menu_feedback,
            R.id.drawer_menu_help
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shortcuts_act);

        // Set up the toolbar.
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        actionBar.setDisplayHomeAsUpEnabled(true);

        // Set up the navigation drawer.
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerLayout.setStatusBarBackground(R.color.colorPrimaryDark);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView != null) {
            setupDrawerContent(navigationView);
        }

        initFragments();
        initView();
        test();
    }

    private void test(){
        String url;
        if (Build.VERSION.SDK_INT <8) {
            url = "content://com.android.launcher.settings/favorites?Notify=true";
        } else if(Build.VERSION.SDK_INT < 19){
            url = "content://com.android.launcher2.settings/favorites?Notify=true";
        }else {
            url = "content://com.android.launcher3.settings/favorites?Notify=true";
        }

        ContentResolver resolver = getContentResolver();
        Cursor cursor = resolver.query (Uri.parse(url), null, null, null, null);
        if(cursor != null){

        }
    }

    private void initFragments(){
        //Set up the content fragment
        ShortcutsFragment fragment = (ShortcutsFragment) getSupportFragmentManager()
                .findFragmentById(R.id.contentFrame);
        if(fragment == null){
            fragment = ShortcutsFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager()
                    , fragment, R.id.contentFrame, TAG_FRAGMENT_MAIN);
        }
    }

    private void initView(){
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShortcutsActivity.this, EditActivity.class);
                intent.putExtra(Constants.KEY_ACTIVITY_FLAG, EditActivity.ACTIVTY_FLAG_CREATE);
                startActivity(intent);
            }
        });
    }

    private void setupDrawerContent(NavigationView navigationView){
        navigationView.setNavigationItemSelectedListener(this);
        naviMenu = navigationView.getMenu();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // Open the navigation drawer when the home icon is selected from the toolbar.
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        mDrawerLayout.closeDrawer(Gravity.LEFT);
        checkNaviMenuItem(item);
        if(item.getItemId() == R.id.drawer_menu_main){
            fab.setVisibility(View.VISIBLE);
        }else {
            fab.setVisibility(View.GONE);
        }

        switch (item.getItemId()) {
            case R.id.drawer_menu_setting:

                break;
            case R.id.drawer_menu_main:
                if(getSupportFragmentManager().findFragmentByTag(TAG_FRAGMENT_MAIN) == null){
                    ShortcutsFragment shortcutsFragment = ShortcutsFragment.newInstance();
                    ActivityUtils.addFragmentToActivity(getSupportFragmentManager()
                            , shortcutsFragment, R.id.contentFrame, TAG_FRAGMENT_MAIN);
                }
                switchFragment(TAG_FRAGMENT_MAIN);
                break;
            case R.id.drawer_menu_feedback:
                if(getSupportFragmentManager().findFragmentByTag(TAG_FRAGMENT_FEEDBACK) == null){
                    FeedbackFragment feedbackFragment = FeedbackFragment.newInstance();
                    ActivityUtils.addFragmentToActivity(getSupportFragmentManager()
                            , feedbackFragment, R.id.contentFrame, TAG_FRAGMENT_FEEDBACK);
                }
                switchFragment(TAG_FRAGMENT_FEEDBACK);
                break;
            case R.id.drawer_menu_help:
                if(getSupportFragmentManager().findFragmentByTag(TAG_FRAGMENT_HELP) == null){
                    HelpFragment helpFragment = HelpFragment.newInstance();
                    ActivityUtils.addFragmentToActivity(getSupportFragmentManager()
                            , helpFragment, R.id.contentFrame, TAG_FRAGMENT_HELP);
                }
                switchFragment(TAG_FRAGMENT_HELP);
                break;
        }
        return true;
    }

    private void checkNaviMenuItem(MenuItem item){
        item.setChecked(true);

        for (int i=0;i<menuIds.length;i++){
            int id = menuIds[i];
            if(id != item.getItemId()){
                //取消选择其它item
                naviMenu.findItem(id).setChecked(false);
            }
        }
    }

    private void switchFragment(String fragmentTag){
        for (Fragment fragment : getSupportFragmentManager().getFragments()){
            if(fragmentTag.equals(fragment.getTag())){
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.show(fragment);
                transaction.commit();
            }else {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.hide(fragment);
                transaction.commit();
            }
        }
    }
}

package com.softdesign.devintensive.ui.activities;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.softdesign.devintensive.R;
import com.softdesign.devintensive.utils.ConstantManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    public static final String TAG = ConstantManager.TAG_PREFIX + "Main Activity ";
    private int mCurrentEditMode = 0;

    private ImageView progress;
    private CoordinatorLayout mCoordinatorLayout;
    private Toolbar mToolbar;
    private DrawerLayout mNavigationDrawer;
    private FloatingActionButton mFloatingActionButton;
    private EditText phone_edit_text, email_edit_text, vk_edit_text, github_edit_text, about_edit_text;
    private List<EditText> mUserInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate");

        if(savedInstanceState != null) {

            mCurrentEditMode = savedInstanceState.getInt(ConstantManager.EDIT_MODE_KEY, 0);
            changeEditMode(mCurrentEditMode);
        }

        mCoordinatorLayout = (CoordinatorLayout)findViewById(R.id.main_coordinator_container);

        showSnackbar("Hello World111");

        mToolbar = (Toolbar)findViewById(R.id.toolbar);
        setupToolbar();

        mNavigationDrawer = (DrawerLayout)findViewById(R.id.navigation_drawer);
        setupDrawer();



        mFloatingActionButton = (FloatingActionButton)findViewById(R.id.fab);

        mFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mCurrentEditMode == 0) {
                    changeEditMode(1);
                }else {
                    changeEditMode(0);
                }
            }
        });

        phone_edit_text = (EditText)findViewById(R.id.phone_edit_text);
        email_edit_text = (EditText)findViewById(R.id.email_edit_text);
        vk_edit_text = (EditText)findViewById(R.id.vk_edit_text);
        github_edit_text = (EditText)findViewById(R.id.github_edit_text);
        about_edit_text = (EditText)findViewById(R.id.about_edit_text);

        mUserInfo = new ArrayList<>();
        mUserInfo.add(phone_edit_text);
        mUserInfo.add(email_edit_text);
        mUserInfo.add(vk_edit_text);
        mUserInfo.add(github_edit_text);
        mUserInfo.add(about_edit_text);


/*
        progress = (ImageView)findViewById(R.id.progress);
        progress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               showProgress();
            }
        });
        */

    }



    private void changeEditMode(int mode){

        mFloatingActionButton.setImageResource(R.drawable.ic_done_black_24dp);
        if(mode == 1){
           for(EditText userValue : mUserInfo){
               userValue.setEnabled(true);
               userValue.setFocusable(true);
               userValue.setFocusableInTouchMode(true);
           }
       }else {
            mFloatingActionButton.setImageResource(R.drawable.ic_build_black_24dp);
            for(EditText userValue : mUserInfo){
               userValue.setEnabled(false);
               userValue.setFocusable(false);
               userValue.setFocusableInTouchMode(false);

           }
       }

    }

    private void loadUserInfoValue(){

    }

    private void saveUserInfoValue(){

    }

    protected void onSaveInstanceState(Bundle bundle){
        super.onSaveInstanceState(bundle);
        bundle.putInt(ConstantManager.EDIT_MODE_KEY, mCurrentEditMode);
    }

    private void showSnackbar(String message){
        Snackbar.make(mCoordinatorLayout, message, Snackbar.LENGTH_SHORT).show();
    }


    private void setupToolbar(){

        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }


    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == android.R.id.home){
            mNavigationDrawer.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupDrawer(){
        NavigationView navigationView = (NavigationView)findViewById(R.id.navigation_view);
        showToast("Work");

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                showSnackbar(item.getTitle().toString());
                item.setCheckable(true);
                mNavigationDrawer.closeDrawer(GravityCompat.START);
                return false;
            }
        });

    }


    @Override
    protected void onStart(){
        super.onStart();
        Log.d(TAG, "onStart");

    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG, "onResume");

    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG, "onPause");

    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "onDestroy");

    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d(TAG, "onRestart");

    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d(TAG, "onStop");

    }

}

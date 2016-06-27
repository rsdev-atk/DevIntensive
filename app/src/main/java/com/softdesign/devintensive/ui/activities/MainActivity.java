package com.softdesign.devintensive.ui.activities;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.softdesign.devintensive.R;
import com.softdesign.devintensive.utils.ConstantManager;

public class MainActivity extends BaseActivity {

    public static final String TAG = ConstantManager.TAG_PREFIX + "Main Activity ";

    private ImageView progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate");

        progress = (ImageView)findViewById(R.id.progress);
        progress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               showProgress();
                runWithDelay();
            }
        });

    }

    private void runWithDelay(){
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                hideProgress();
            }
        },5000);
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

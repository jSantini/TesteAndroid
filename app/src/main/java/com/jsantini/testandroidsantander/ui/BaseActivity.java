package com.jsantini.testandroidsantander.ui;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jsantini.testandroidsantander.R;
import com.jsantini.testandroidsantander.ui.dialog.LoadingDialog;
import com.jsantini.testandroidsantander.ui.util.Utils;


public class BaseActivity extends AppCompatActivity {

    private boolean isActive;
    private LoadingDialog loadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        overridePendingTransition(R.anim.slide_in_rigth_to_left, R.anim.slide_out_rigth_to_left);
    }

    @Override
    protected void onResume() {
        super.onResume();
        isActive = true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        isActive = false;
    }

    public Context getContext() {
        return this;
    }

    public Activity getActivity() {
        return this;
    }

    public void showOrHideLoading(final boolean isShowLoading, final String msg) {
        if(isShowLoading) {
            showLoading(msg);
        } else {
            hideLoading();
        }
    }

    private void showLoading(final String msg) {
        Utils.hideKeyboard(this);
        hideLoading();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        loadingDialog = LoadingDialog.newInstance(msg);
        loadingDialog.setCancelable(false);
        loadingDialog.show(ft, "dialog");
    }

    private void hideLoading() {
        if(loadingDialog != null) {
            loadingDialog.dismiss();
        }
    }

    public boolean isActive() {
        return isActive;
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left_to_rigth, R.anim.slide_out_left_to_rigth);
    }

    public void showGenericError() {

    }

    public void showConnectionError() {

    }

}

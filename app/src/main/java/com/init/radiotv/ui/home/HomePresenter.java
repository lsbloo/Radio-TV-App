package com.init.radiotv.ui.home;

import android.app.ProgressDialog;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

public interface HomePresenter {

    void executeRadio();
    void executeTV();
    void executeInfo();
    void stopRadio();
    void stopTv();
    void changeFragment(Fragment fragment);


    void getClick(ImageView view,String type);

    void executeProgressDialog(ProgressDialog progressDialog);
}

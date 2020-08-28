package com.init.radiotv.ui.home;

import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.fragment.app.FragmentManager;

public interface HomeView {

    void setExecuteRadio();
    void setExecuteTv();

    void getClick(ImageView view, String type);

    FragmentManager getSupportManager();

    Integer getBaseFragmentFrameLayout();


    void executeProgressDialog();
}

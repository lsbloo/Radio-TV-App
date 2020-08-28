package com.init.radiotv.ui.home;

import android.app.ProgressDialog;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.init.radiotv.di.component.RadioTVFragment;
import com.init.radiotv.di.component.TvFragment;
import com.init.radiotv.service.AsyncTransactionFragment;
import com.init.radiotv.utils.Constants;

public class HomePresenterImpl implements  HomePresenter {


    private HomeView homeView;


    public HomePresenterImpl(HomeView homeView){
        this.homeView=homeView;
    }


    @Override
    public void executeRadio() {
        Fragment fragmentRadio = new RadioTVFragment();
        changeFragment(fragmentRadio);
    }

    @Override
    public void executeTV() {
        Fragment fragmentRadio = new TvFragment();
        changeFragment(fragmentRadio);
    }

    @Override
    public void executeInfo() {

    }

    @Override
    public void stopRadio() {

    }

    @Override
    public void stopTv() {

    }

    @Override
    public void changeFragment(Fragment fragment) {

        this.homeView.executeProgressDialog();

        FragmentTransaction fragmentTransaction = homeView.getSupportManager().beginTransaction();
        fragmentTransaction.replace(homeView.getBaseFragmentFrameLayout(),fragment);
        fragmentTransaction.commit();

    }


    @Override
    public void getClick(ImageView view,String type) {

        if(type.equals(Constants.RADIO_TV_BUTTON)){
            executeRadio();
        }else if (type.equals(Constants.TV_BUTTON)){
            executeTV();
        }

    }

    @Override
    public void executeProgressDialog(final ProgressDialog progressDialog) {
        AsyncTransactionFragment asyncTransactionFragment = new AsyncTransactionFragment(progressDialog);
        asyncTransactionFragment.execute();
    }
}

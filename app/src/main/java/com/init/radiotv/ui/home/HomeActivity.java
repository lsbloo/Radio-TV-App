package com.init.radiotv.ui.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.init.radiotv.R;
import com.init.radiotv.utils.Constants;
import com.michaldrabik.tapbarmenulib.TapBarMenu;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity implements HomeView{


    private HomePresenter presenter;

    @BindView(R.id.img_radiotv)
    ImageView img_radioTV;

    @BindView(R.id.img_tv)
    ImageView img_TV;

    @BindView(R.id.frameLayout)
    FrameLayout frameLayout;

    @BindView(R.id.tapBarMenu)
    TapBarMenu tapBarMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);


       tapBarMenu.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               tapBarMenu.toggle();
           }
       });

       presenter = new HomePresenterImpl(this);

        img_radioTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getClick(img_radioTV, Constants.RADIO_TV_BUTTON);

            }
        });

        img_TV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getClick(img_TV,Constants.TV_BUTTON);
            }
        });
    }

    @Override
    public void setExecuteRadio() {

    }

    @Override
    public void setExecuteTv() {

    }

    @Override
    public void getClick(ImageView view, String type){
        presenter.getClick(view,type);

    }

    @Override
    public FragmentManager getSupportManager() {
        return getSupportFragmentManager();
    }

    @Override
    public Integer getBaseFragmentFrameLayout() {
        return R.id.frameLayout;
    }

    @Override
    public void executeProgressDialog() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        presenter.executeProgressDialog(progressDialog);
    }


}
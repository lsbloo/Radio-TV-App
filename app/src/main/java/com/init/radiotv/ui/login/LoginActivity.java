package com.init.radiotv.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.init.radiotv.R;
import com.init.radiotv.ui.home.HomeActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements LoginView{


    @BindView(R.id.edt_username)
    EditText username;

    @BindView(R.id.edt_password)
    EditText password;

    @BindView(R.id.btn_entrar)
    Button btn_entrar;

    @BindView(R.id.btn_esqueci)
    TextView btn_esqueci_senha;

    private LoginPresenterImpl presenter;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hideActionBar();
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        presenter = new LoginPresenterImpl(this);

        btn_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateCredentials();
            }
        });

    }


    @Override
    public void hideActionBar() {
        getSupportActionBar().hide();
    }

    @Override
    public void setUsernameError() {
        username.setError(getString(R.string.username_error));
    }

    @Override
    public void setPasswordError() {
        password.setError(getString(R.string.password_error));
    }

    @Override
    public void navigateToHome() {
        Intent at = new Intent(this, HomeActivity.class);
        startActivity(at);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {
    }



    private void validateCredentials(){
        presenter.validateCredentials(username.getText().toString(), password.getText().toString());
    }
}
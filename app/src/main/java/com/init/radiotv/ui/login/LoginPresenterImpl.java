package com.init.radiotv.ui.login;

import java.util.HashMap;

public class LoginPresenterImpl implements LoginPresenter{


    private LoginView loginView;


    public LoginPresenterImpl(LoginView loginView){
        this.loginView=loginView;
    }


    public void validateCredentials(String username , String password){
        HashMap<String, Boolean> result = LoginValidator.validatorLogin(username,password);
        if(result.get("username") && result.get("password")){
            onSuccess();
        }else{
            if(!result.get("username")){
                onUsernameError();
            }else if(!result.get("password")){
                onPasswordError();
            }
        }
    }

    public void onDestroy(){
        loginView = null;
    }
    @Override
    public void onUsernameError() {
        if(loginView != null){
            loginView.setUsernameError();
        }
    }

    @Override
    public void onPasswordError() {
        if(loginView != null){
            loginView.setPasswordError();
        }
    }

    @Override
    public void onSuccess() {
        loginView.navigateToHome();
    }

}

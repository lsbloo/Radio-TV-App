package com.init.radiotv.ui.login;

public interface LoginView {

    void hideActionBar();

    void setUsernameError();

    void setPasswordError();

    void navigateToHome();

    void showProgress();

    void hideProgress();

}

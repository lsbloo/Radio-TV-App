package com.init.radiotv.data.model;

import android.os.Parcel;
import android.os.Parcelable;

public class UserLogin implements Parcelable {

    private String username;
    private String password;

    public UserLogin(){

    }

    protected UserLogin(Parcel in) {
        username = in.readString();
        password = in.readString();
    }

    public static final Creator<UserLogin> CREATOR = new Creator<UserLogin>() {
        @Override
        public UserLogin createFromParcel(Parcel in) {
            return new UserLogin(in);
        }

        @Override
        public UserLogin[] newArray(int size) {
            return new UserLogin[size];
        }
    };

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(username);
        parcel.writeString(password);
    }
}

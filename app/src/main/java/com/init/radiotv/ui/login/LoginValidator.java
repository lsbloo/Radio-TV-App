package com.init.radiotv.ui.login;

import java.util.HashMap;

/**
 * Simple Validator InputLogin
 */
public class LoginValidator {
    static HashMap<String,Boolean> validatorLogin(String username , String password){
        HashMap<String,Boolean> validator = new HashMap<>();
        if(username.equals("") || username == null){
            validator.put("username", false);
        }else{
         validator.put("username", true);
        }
        if(password.equals("") || password == null){
            validator.put("password", false);
        }else{
            validator.put("password", true);
        }
     return validator;
    }
}

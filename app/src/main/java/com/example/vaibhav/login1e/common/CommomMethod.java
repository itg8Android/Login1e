package com.example.vaibhav.login1e.common;

import android.content.Context;

import com.example.vaibhav.login1e.rest.RetroControler;

/**
 * Created by swapnilmeshram on 30/03/17.
 */

public class CommomMethod {

    public static final String URL = "http://www.quizeee.com/";
    public static final String USERID = "userID";

    public static RetroControler getController(Context context){
        return Retro.newInstance().getRetro(context).create(RetroControler.class);
    }
}

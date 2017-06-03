package com.example.vaibhav.login1e.rest;

import android.content.Context;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by vaibhav on 28/2/17.
 */
public class Retro {
    private static final String BASE_URL="http://www.quizeee.com";
    private static Retro ourInstance = new Retro();

    public static Retro getInstance() {
        return ourInstance;
    }

    private Retro() {
    }

    public RetroControler getRetrofit(){
        GsonConverterFactory factory = GsonConverterFactory.create();
        
        Retrofit retrofit=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(factory).build();
        return retrofit.create(RetroControler.class);
    }
}

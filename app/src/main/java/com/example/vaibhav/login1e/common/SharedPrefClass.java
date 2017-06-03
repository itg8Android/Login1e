package com.example.vaibhav.login1e.common;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by swapnilmeshram on 13/03/17.
 */

public class SharedPrefClass {
    private static final SharedPrefClass ourInstance = new SharedPrefClass();
    private static final String PREF_NAME = "MySharedPref";
    public static final String USERNAME = "username";
    private static SharedPreferences preference;

    public static SharedPrefClass getInstance(Context context) {
        preference=context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        return ourInstance;
    }

    private SharedPrefClass() {
    }

    public void savePref(String key,String val)
    {
        if(preference!=null)
        {
            SharedPreferences.Editor editor=preference.edit();
            editor.putString(key,val);
            editor.apply();
        }
    }

    public void setLogin(String key, boolean b){
        if(preference!=null)
        {
            SharedPreferences.Editor editor=preference.edit();
            editor.putBoolean(key,b);
            editor.apply();
        }
    }

    public void clearPref(String key)
    {
        if(preference!=null)
        {
            SharedPreferences.Editor editor=preference.edit();
            editor.remove(key);
            editor.apply();
        }
    }

    public String getPref(String key)
    {
        if(preference!=null)
        {
            return preference.getString(key,null);
        }
        return null;
    }

    public boolean hasPreference(String name){
        if(preference!=null)
        {
            return preference.getBoolean(name,false);
        }
        return false;
    }


    public boolean havePreference(String key) {
        return preference.getString(key,null)!=null;
    }
}

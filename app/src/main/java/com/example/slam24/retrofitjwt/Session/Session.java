package com.example.slam24.retrofitjwt.Session;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by SLAM24 on 10/22/2017.
 */

public class Session {
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    Context ctx;

    public Session(Context ctx){
        this.ctx = ctx;
        prefs = ctx.getSharedPreferences("Session",Context.MODE_PRIVATE);
        editor = prefs.edit();
    }
    public void setvarString(String var, String value){
        editor.putString(var,value);
        editor.commit();
    }

    public String getvarString(String var){
        return prefs.getString(var,"");
    }
}

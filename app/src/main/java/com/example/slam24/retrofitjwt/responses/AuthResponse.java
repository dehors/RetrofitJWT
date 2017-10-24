package com.example.slam24.retrofitjwt.responses;

import com.example.slam24.retrofitjwt.models.Auth;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by SLAM24 on 10/21/2017.
 */

public class AuthResponse {
    private Auth data;

    public Auth getData() {
        return data;
    }

    public void setData(Auth data) {
        this.data = data;
    }
}

package com.example.walkplanetcat_mobile.MODELS;

import com.google.gson.annotations.SerializedName;

public class Login {

    // REQUEST
    @SerializedName("name")
    private String name;

    public String getName() {
        return name;
    }

    @SerializedName("password")
    private String password;

    public String getPassword() {
        return password;
    }

    // RESPONSE
    @SerializedName("checked")
    private String checked;

    public String getChecked() {
        return checked;
    }

    // 생성자
    public Login(String name, String password){
        this.name = name;
        this.password = password;
    }
}

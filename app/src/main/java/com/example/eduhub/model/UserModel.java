package com.example.eduhub.model;

import com.example.eduhub.utils.ColorUtils;

public class UserModel {
    private String email, name, color;
    UserModel(String email, String name) {
        this.email = email;
        this.name = name;
        this.color = ColorUtils.generateRandomRainbowColorHex();
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public void setName(String name) {
        this.name = name;
    }
}

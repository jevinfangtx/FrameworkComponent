package com.tencent.component.architecture;


import android.text.TextUtils;

public class Webservice {
    private String userId;

    public Webservice getUser(String userId) {
        this.userId = userId;
        return this;
    }

    public void enqueue(Callback<User> callback) {
        User user = new User();
        user.name = "fang1";
        if (TextUtils.equals(userId, "1")) {
            user.name = "fang2";
        }
        callback.onCallback(user);
    }
}

package com.tencent.component.architecture;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

public class UserRepository {
    private Webservice webservice = new Webservice();

    public LiveData<User> getUser(String userId) {
        final MutableLiveData<User> data = new MutableLiveData<>();
        webservice.getUser(userId).enqueue(new Callback<User>() {
            @Override
            public void onCallback(User data) {
                data.setName(data.name);
            }
        });
        return data;
    }
}

package com.tencent.component.architecture;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

public class UserProfileViewModel extends ViewModel {

    private String userId;
    private LiveData<User> user;
    private UserRepository userRepository;

    public void init(String userId) {
        if (this.user != null) {
            return;
        }
        this.userId = userId;
        user = userRepository.getUser(userId);
    }

    public LiveData<User> getUser() {
        return user;
    }
}

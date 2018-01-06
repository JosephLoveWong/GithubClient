package com.promiseland.githubclient.data.api;

import com.promiseland.githubclient.data.UserScope;
import com.promiseland.githubclient.data.model.User;

import dagger.Module;
import dagger.Provides;

/**
 * Created by joseph on 2018/1/6.
 */

@Module
public class UserModule {
    private User mUser;

    public UserModule(User user) {
        mUser = user;
    }

    @UserScope
    @Provides
    public User provideUser() {
        return mUser;
    }
}

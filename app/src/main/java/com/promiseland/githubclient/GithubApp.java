package com.promiseland.githubclient;

import android.app.Application;
import android.content.Context;

import com.promiseland.githubclient.data.UserSubComponent;
import com.promiseland.githubclient.data.api.UserModule;
import com.promiseland.githubclient.data.model.User;

import timber.log.Timber;

/**
 * Created by joseph on 2018/1/3.
 */

public class GithubApp extends Application {
    AppComponent appComponent;
    UserSubComponent userSubComponent;

    public static GithubApp get(Context context) {
        return (GithubApp) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }

        initAppComponent();
    }

    private void initAppComponent() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public void createUserSubComponent(User user) {
        userSubComponent = appComponent.plus(new UserModule(user));
    }

    public void releaseUserSubComponent() {
        userSubComponent = null;
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public UserSubComponent getUserSubComponent() {
        return userSubComponent;
    }
}

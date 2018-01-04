package com.promiseland.githubclient.ui.splash.di;

import com.promiseland.githubclient.ui.splash.SplashActivity;

import dagger.Subcomponent;

/**
 * Created by Administrator on 2018/1/4.
 */
@Subcomponent(modules = SplashActivityModule.class)
public interface SplashActivitySubComponent {
    void inject(SplashActivity activity);
}

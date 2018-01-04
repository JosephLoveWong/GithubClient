package com.promiseland.githubclient;

import com.promiseland.githubclient.data.api.GithubApiModule;
import com.promiseland.githubclient.ui.splash.di.SplashActivityModule;
import com.promiseland.githubclient.ui.splash.di.SplashActivitySubComponent;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by joseph on 2018/1/3.
 */

@Singleton
@Component(modules = {
        AppModule.class,
        GithubApiModule.class
})
public interface AppComponent {
    SplashActivitySubComponent plus(SplashActivityModule module);
}

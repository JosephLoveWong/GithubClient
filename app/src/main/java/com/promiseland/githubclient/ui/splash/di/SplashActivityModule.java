package com.promiseland.githubclient.ui.splash.di;

import com.promiseland.githubclient.data.api.RepositoryManager;
import com.promiseland.githubclient.data.api.UserManager;
import com.promiseland.githubclient.ui.splash.SplashContract;
import com.promiseland.githubclient.ui.splash.SplashPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2018/1/4.
 */

@Module
public class SplashActivityModule {
    private SplashContract.View view;

    public SplashActivityModule(SplashContract.View view) {
        this.view = view;
    }

    @Provides
    public SplashContract.View provideView() {
        return view;
    }

    @Provides
    public SplashContract.Presenter providePresenter(SplashContract.View view, UserManager userManager, RepositoryManager repositoryManager) {
        return new SplashPresenter(view, userManager, repositoryManager);
    }
}

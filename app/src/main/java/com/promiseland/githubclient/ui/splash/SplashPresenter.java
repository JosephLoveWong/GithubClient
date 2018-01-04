package com.promiseland.githubclient.ui.splash;

/**
 * Created by Administrator on 2017/6/8.
 */

public class SplashPresenter implements SplashContract.Presenter {
    private SplashContract.View mView;
    private String username;

    public SplashPresenter(SplashContract.View view) {
        mView = view;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void showRepositories() {
        // TODO

    }

}

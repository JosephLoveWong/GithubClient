package com.promiseland.githubclient.ui.splash;

import android.text.TextUtils;

import com.promiseland.githubclient.data.api.RepositoryManager;
import com.promiseland.githubclient.data.api.UserManager;
import com.promiseland.githubclient.data.model.User;
import com.promiseland.githubclient.utils.SimpleObserver;

/**
 * Created by Administrator on 2017/6/8.
 */

public class SplashPresenter implements SplashContract.Presenter {
    private SplashContract.View mView;
    private UserManager mUserManager;
    private RepositoryManager mRepositoryManager;
    private String username;

    public SplashPresenter(SplashContract.View view, UserManager userManager, RepositoryManager repositoryManager) {
        mView = view;
        mUserManager = userManager;
        mRepositoryManager = repositoryManager;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void checkUser() {
        if (TextUtils.isEmpty(username)) {
            mView.showValidationError();
        } else {
            mView.showLoading(true);
            mUserManager.getUser(username)
                    .subscribe(new SimpleObserver<User>() {
                        @Override
                        public void onNext(User user) {
                            super.onNext(user);
                            mView.showLoading(false);
                            mView.showRepositoriesListForUser(user);
                        }

                        @Override
                        public void onError(Throwable e) {
                            super.onError(e);
                            mView.showLoading(false);
                            mView.showValidationError();
                        }
                    });
        }

    }

}

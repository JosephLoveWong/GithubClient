package com.promiseland.githubclient.ui.splash;

import com.promiseland.githubclient.BasePresenter;
import com.promiseland.githubclient.BaseView;
import com.promiseland.githubclient.data.model.User;


/**
 * Created by Administrator on 2017/6/8.
 */

public interface SplashContract {

    interface View extends BaseView<Presenter> {
        void showLoading(boolean loading);
        void showValidationError();
        void showRepositoriesListForUser(User user);
    }

    interface Presenter extends BasePresenter {
        void checkUser();
        void setUsername(String username);
    }
}

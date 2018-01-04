package com.promiseland.githubclient.ui.splash;

import com.promiseland.githubclient.BasePresenter;
import com.promiseland.githubclient.BaseView;


/**
 * Created by Administrator on 2017/6/8.
 */

public interface SplashContract {

    interface View extends BaseView<Presenter> {
        void showLoading(boolean loading);
        void showRepositoriesListForUser(String username);
        void showValidationError();
    }

    interface Presenter extends BasePresenter {
        void showRepositories();
        void setUsername(String username);
    }
}

package com.promiseland.githubclient.ui.repositoryDetail;

import com.promiseland.githubclient.BasePresenter;
import com.promiseland.githubclient.BaseView;

/**
 * Created by Administrator on 2018/1/5.
 */

public interface RepositoryDetailContract {
    interface View extends BaseView<Presenter> {
        void setupUserName(String name);
    }

    interface Presenter extends BasePresenter {
        void init();
    }
}

package com.promiseland.githubclient.ui.repositoryList;

import com.promiseland.githubclient.BasePresenter;
import com.promiseland.githubclient.BaseView;
import com.promiseland.githubclient.data.model.Repository;

import java.util.List;

/**
 * Created by Administrator on 2018/1/5.
 */

public interface RepositoryListContract {
    interface View extends BaseView<Presenter> {
        void showLoading(boolean loading);
        void showRepositories(List<Repository> repositories);
    }

    interface Presenter extends BasePresenter {
        void showRepositories();
    }
}

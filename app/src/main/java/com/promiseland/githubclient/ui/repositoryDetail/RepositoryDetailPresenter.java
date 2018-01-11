package com.promiseland.githubclient.ui.repositoryDetail;

import com.promiseland.githubclient.data.model.User;

/**
 * Created by Administrator on 2018/1/5.
 */

public class RepositoryDetailPresenter implements RepositoryDetailContract.Presenter {
    private RepositoryDetailContract.View mView;
    private User mUser;

    public RepositoryDetailPresenter(RepositoryDetailContract.View view, User user) {
        mView = view;
        mUser = user;
    }

    @Override
    public void init() {
        mView.setupUserName(mUser.login);
    }
}

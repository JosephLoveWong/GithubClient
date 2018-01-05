package com.promiseland.githubclient.ui.repositoryList;

/**
 * Created by Administrator on 2018/1/5.
 */

public class RepositoryListPresenter implements RepositoryListContract.Presenter{
    private RepositoryListContract.View mView;

    public RepositoryListPresenter(RepositoryListContract.View view) {
        mView = view;
    }

    @Override
    public void showRepositories() {
        // TODO
    }
}

package com.promiseland.githubclient.ui.repositoryList;

import com.promiseland.githubclient.data.api.RepositoryManager;
import com.promiseland.githubclient.data.model.Repository;
import com.promiseland.githubclient.data.model.User;
import com.promiseland.githubclient.utils.SimpleObserver;

import java.util.List;

/**
 * Created by Administrator on 2018/1/5.
 */

public class RepositoryListPresenter implements RepositoryListContract.Presenter {
    private RepositoryListContract.View mView;
    private RepositoryManager mRepositoryManager;
    private User mUser;

    public RepositoryListPresenter(RepositoryListContract.View view, RepositoryManager repositoryManager, User user) {
        mView = view;
        mRepositoryManager = repositoryManager;
        mUser = user;
    }

    @Override
    public void showRepositories() {
        mView.showLoading(true);
        mRepositoryManager.getRepositoryListForUser(mUser)
                .subscribe(new SimpleObserver<List<Repository>>(){
                    @Override
                    public void onNext(List<Repository> repositories) {
                        super.onNext(repositories);
                        mView.showLoading(false);
                        mView.showRepositories(repositories);
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        mView.showLoading(false);
                    }
                });
    }
}

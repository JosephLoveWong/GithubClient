package com.promiseland.githubclient.ui.repositoryList.di;

import com.promiseland.githubclient.ui.repositoryList.RepositoryListContract;
import com.promiseland.githubclient.ui.repositoryList.RepositoryListPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2018/1/5.
 */

@Module
public class RepositoryListModule {
    private RepositoryListContract.View mView;

    public RepositoryListModule(RepositoryListContract.View view) {
        mView = view;
    }

    @Provides
    RepositoryListContract.View provideView() {
        return mView;
    }

    @Provides
    RepositoryListContract.Presenter providePresenter(RepositoryListContract.View view) {
        // todo
        return new RepositoryListPresenter(view);
    }

}

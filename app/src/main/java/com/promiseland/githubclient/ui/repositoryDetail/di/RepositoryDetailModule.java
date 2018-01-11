package com.promiseland.githubclient.ui.repositoryDetail.di;

import com.promiseland.githubclient.data.model.User;
import com.promiseland.githubclient.ui.repositoryDetail.RepositoryDetailContract;
import com.promiseland.githubclient.ui.repositoryDetail.RepositoryDetailPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2018/1/5.
 */

@Module
public class RepositoryDetailModule {
    private RepositoryDetailContract.View mView;

    public RepositoryDetailModule(RepositoryDetailContract.View view) {
        mView = view;
    }

    @Provides
    RepositoryDetailContract.View provideView() {
        return mView;
    }

    @Provides
    RepositoryDetailContract.Presenter providePresenter(RepositoryDetailContract.View view, User user) {
        return new RepositoryDetailPresenter(view, user);
    }

}

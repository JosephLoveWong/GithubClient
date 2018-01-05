package com.promiseland.githubclient.ui.repositoryList.di;

import com.promiseland.githubclient.ui.repositoryList.RepositoryListActivity;

import dagger.Subcomponent;

/**
 * Created by Administrator on 2018/1/5.
 */
@Subcomponent(modules = RepositoryListModule.class)
public interface RepositoryListSubComponent {
    void inject(RepositoryListActivity activity);
}

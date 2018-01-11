package com.promiseland.githubclient.ui.repositoryList.di;

import com.promiseland.githubclient.ui.repositoryList.RepositoriesListActivity;

import dagger.Subcomponent;

/**
 * Created by Administrator on 2018/1/5.
 */
@Subcomponent(modules = RepositoriesListModule.class)
public interface RepositoriesListSubComponent {
    void inject(RepositoriesListActivity activity);
}

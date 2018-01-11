package com.promiseland.githubclient.ui.repositoryDetail.di;

import com.promiseland.githubclient.ui.repositoryDetail.RepositoryDetailActivity;

import dagger.Subcomponent;

/**
 * Created by Administrator on 2018/1/5.
 */
@Subcomponent(modules = RepositoryDetailModule.class)
public interface RepositoryDetailSubComponent {
    void inject(RepositoryDetailActivity activity);
}

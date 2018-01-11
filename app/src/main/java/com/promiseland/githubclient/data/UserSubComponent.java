package com.promiseland.githubclient.data;

import com.promiseland.githubclient.data.api.UserModule;
import com.promiseland.githubclient.ui.repositoryList.di.RepositoriesListModule;
import com.promiseland.githubclient.ui.repositoryList.di.RepositoriesListSubComponent;

import dagger.Subcomponent;

/**
 * Created by joseph on 2018/1/6.
 */
@UserScope
@Subcomponent(modules = {
        UserModule.class
})
public interface UserSubComponent {
    RepositoriesListSubComponent plus(RepositoriesListModule module);
}

package com.promiseland.githubclient.ui.repositoryList.di;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.promiseland.githubclient.data.api.RepositoryManager;
import com.promiseland.githubclient.data.model.Repository;
import com.promiseland.githubclient.data.model.User;
import com.promiseland.githubclient.ui.repositoryList.RepositoriesListContract;
import com.promiseland.githubclient.ui.repositoryList.RepositoriesListPresenter;
import com.promiseland.githubclient.ui.repositoryList.adapter.RepositoriesListAdapter;
import com.promiseland.githubclient.ui.repositoryList.adapter.viewholder.RepositoriesListViewHolderFactory;
import com.promiseland.githubclient.ui.repositoryList.adapter.viewholder.RepositoryViewHolderBigFactory;
import com.promiseland.githubclient.ui.repositoryList.adapter.viewholder.RepositoryViewHolderFeaturedFactory;
import com.promiseland.githubclient.ui.repositoryList.adapter.viewholder.RepositoryViewHolderNormalFactory;

import java.util.Map;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntKey;
import dagger.multibindings.IntoMap;

/**
 * Created by Administrator on 2018/1/5.
 */

@Module
public class RepositoriesListModule {
    private RepositoriesListContract.View mView;

    public RepositoriesListModule(RepositoriesListContract.View view) {
        mView = view;
    }

    @Provides
    RepositoriesListContract.View provideView() {
        return mView;
    }

    @Provides
    RepositoriesListContract.Presenter providePresenter(RepositoriesListContract.View view, RepositoryManager manager, User user) {
        return new RepositoriesListPresenter(view, manager, user);
    }

    @Provides
    RepositoriesListAdapter provideRepositoriesListAdapter(RepositoriesListContract.View view,
                                                           Map<Integer, RepositoriesListViewHolderFactory> viewHolderFactories) {
        return new RepositoriesListAdapter(view, viewHolderFactories);
    }

    @Provides
    RecyclerView.LayoutManager provideLayoutManager(Context context) {
        return new LinearLayoutManager(context);
    }

    @Provides
    @IntoMap
    @IntKey(Repository.TYPE_NORMAL)
    RepositoriesListViewHolderFactory provideViewHolderNormal() {
        return new RepositoryViewHolderNormalFactory();
    }

    @Provides
    @IntoMap
    @IntKey(Repository.TYPE_BIG)
    RepositoriesListViewHolderFactory provideViewHolderBig() {
        return new RepositoryViewHolderBigFactory();
    }

    @Provides
    @IntoMap
    @IntKey(Repository.TYPE_FEATURED)
    RepositoriesListViewHolderFactory provideViewHolderFeatured(){
        return new RepositoryViewHolderFeaturedFactory();
    }
}

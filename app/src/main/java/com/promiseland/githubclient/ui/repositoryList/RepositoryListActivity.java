package com.promiseland.githubclient.ui.repositoryList;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;

import com.promiseland.githubclient.GithubApp;
import com.promiseland.githubclient.R;
import com.promiseland.githubclient.ui.BaseActivity;
import com.promiseland.githubclient.ui.repositoryList.di.RepositoryListModule;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/1/5.
 */

public class RepositoryListActivity extends BaseActivity implements RepositoryListContract.View{
    @BindView(R.id.pbLoading)
    ProgressBar pbLoading;
    @BindView(R.id.rvRepositories)
    RecyclerView rvRepositories;

    @Inject
    RepositoryListContract.Presenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repositories_list);

        ButterKnife.bind(this);
    }

    @Override
    protected void setupActivityComponent() {
        GithubApp.get(this)
                .getAppComponent()
                .plus(new RepositoryListModule(this))
                .inject(this);
    }

    @Override
    public void setPresenter(RepositoryListContract.Presenter presenter) {

    }

    @Override
    public void showLoading(boolean loading) {

    }

    @Override
    public void showValidationError() {

    }
}

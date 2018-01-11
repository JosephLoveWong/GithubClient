package com.promiseland.githubclient.ui.repositoryDetail;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.promiseland.githubclient.GithubApp;
import com.promiseland.githubclient.R;
import com.promiseland.githubclient.data.model.Repository;
import com.promiseland.githubclient.ui.BaseActivity;
import com.promiseland.githubclient.ui.repositoryDetail.di.RepositoryDetailModule;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/1/5.
 */

public class RepositoryDetailActivity extends BaseActivity implements RepositoryDetailContract.View{
    private static final String ARG_REPOSITORY = "arg_repository";

    @BindView(R.id.tvRepoName)
    TextView tvRepoName;
    @BindView(R.id.tvRepoDetails)
    TextView tvRepoDetails;
    @BindView(R.id.tvUserName)
    TextView tvUserName;

    @Inject
    RepositoryDetailContract.Presenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repository_details);
        ButterKnife.bind(this);

        Repository repository = getIntent().getParcelableExtra(ARG_REPOSITORY);
        tvRepoName.setText(repository.name);
        tvRepoDetails.setText(repository.url);

        mPresenter.init();
    }

    @Override
    public void setPresenter(RepositoryDetailContract.Presenter presenter) {

    }

    @Override
    protected void setupActivityComponent() {
        GithubApp.get(this)
                .getUserSubComponent()
                .plus(new RepositoryDetailModule(this))
                .inject(this);
    }

    public static void startWithRepository(Repository repository, Activity startingActivity) {
        Intent intent = new Intent(startingActivity, RepositoryDetailActivity.class);
        intent.putExtra(ARG_REPOSITORY, repository);
        startingActivity.startActivity(intent);
    }

    @Override
    public void setupUserName(String name) {
        tvUserName.setText(name);
    }
}

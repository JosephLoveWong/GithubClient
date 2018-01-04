package com.promiseland.githubclient.ui.splash;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.jakewharton.rxbinding2.widget.RxTextView;
import com.promiseland.githubclient.GithubApp;
import com.promiseland.githubclient.R;
import com.promiseland.githubclient.ui.BaseActivity;
import com.promiseland.githubclient.ui.splash.di.SplashActivityModule;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import timber.log.Timber;

/**
 * Created by Administrator on 2018/1/4.
 */

public class SplashActivity extends BaseActivity implements SplashContract.View{
    @BindView(R.id.etUsername)
    EditText etUsername;
    @BindView(R.id.btnShowRepositories)
    Button btnShowRepositories;
    @BindView(R.id.pbLoading)
    ProgressBar pbLoading;

    @Inject
    SplashContract.Presenter mPresenter;
    private Disposable subscribe;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        subscribe = RxTextView.textChanges(etUsername).subscribe(new Consumer<CharSequence>() {
            @Override
            public void accept(CharSequence charSequence) throws Exception {
                mPresenter.setUsername(charSequence.toString());
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        subscribe.dispose();
    }

    @Override
    protected void setupActivityComponent() {
        // Inject
        GithubApp.get(this)
                .getAppComponent()
                .plus(new SplashActivityModule(this))
                .inject(this);
    }

    @Override
    public void setPresenter(SplashContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @OnClick(R.id.btnShowRepositories)
    public void showRepositories() {
        mPresenter.showRepositories();
    }

    @Override
    public void showLoading(boolean loading) {
        btnShowRepositories.setVisibility(loading ? View.GONE : View.VISIBLE);
        pbLoading.setVisibility(loading ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showRepositoriesListForUser(String username) {
        Timber.e(username);
    }

    @Override
    public void showValidationError() {
        etUsername.setError("Validation error");
    }
}

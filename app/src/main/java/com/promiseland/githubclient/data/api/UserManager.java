package com.promiseland.githubclient.data.api;

import com.promiseland.githubclient.data.api.response.UserResponse;
import com.promiseland.githubclient.data.model.User;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/1/4.
 */

public class UserManager {
    private GithubApiService mGithubApiService;

    public UserManager(GithubApiService githubApiService) {
        mGithubApiService = githubApiService;
    }

    public Observable<User> getUser(final String username) {
        return mGithubApiService.getUser(username)
                .map(new Function<UserResponse, User>() {
                    @Override
                    public User apply(UserResponse userResponse) throws Exception {
                        User user = new User();
                        user.id = userResponse.id;
                        user.login = userResponse.login;
                        user.url = userResponse.url;
                        return user;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}

package com.promiseland.githubclient.data.api;

import com.promiseland.githubclient.data.api.response.UserResponse;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2018/1/4.
 */

public class UserManager {
    private GithubApiService mGithubApiService;

    public UserManager(GithubApiService githubApiService) {
        mGithubApiService = githubApiService;
    }

    // TODO
    public Observable<UserResponse> getUser(String username) {
        return mGithubApiService.getUser(username);
    }
}

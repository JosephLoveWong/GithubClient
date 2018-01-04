package com.promiseland.githubclient.data.api;

import com.promiseland.githubclient.data.api.response.RepositoryResponse;
import com.promiseland.githubclient.data.api.response.UserResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by joseph on 2018/1/3.
 */

public interface GithubApiService {

    @GET("/users/{username}")
    Observable<UserResponse> getUser(@Path("username") String username);

    @GET("/users/{username}/repos")
    Observable<List<RepositoryResponse>> getUsersRepositories(@Path("username") String username);

}

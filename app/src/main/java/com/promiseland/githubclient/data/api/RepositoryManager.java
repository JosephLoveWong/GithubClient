package com.promiseland.githubclient.data.api;

import com.promiseland.githubclient.data.api.response.RepositoryResponse;
import com.promiseland.githubclient.data.model.Repository;
import com.promiseland.githubclient.data.model.User;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/1/5.
 */

public class RepositoryManager {
    private GithubApiService mGithubApiService;

    public RepositoryManager(GithubApiService githubApiService) {
        mGithubApiService = githubApiService;
    }

    public Observable<List<Repository>>  getRepositoryListForUser(User user) {
        return mGithubApiService.getUsersRepositories(user.login)
                .map(new Function<List<RepositoryResponse>, List<Repository>>() {
                    @Override
                    public List<Repository> apply(List<RepositoryResponse> repositoryResponses) throws Exception {
                        List<Repository> repositories = new ArrayList<>();
                        for(RepositoryResponse repositoryResponse : repositoryResponses) {
                            Repository repository = new Repository();
                            repository.id = repositoryResponse.id;
                            repository.name = repositoryResponse.name;
                            repository.url = repositoryResponse.url;
                            repository.forks_count = repositoryResponse.forks_count;
                            repository.stargazers_count = repositoryResponse.stargazers_count;

                            repositories.add(repository);
                        }
                        return repositories;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}

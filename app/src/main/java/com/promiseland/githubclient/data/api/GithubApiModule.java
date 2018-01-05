package com.promiseland.githubclient.data.api;

import android.app.Application;

import com.promiseland.githubclient.BuildConfig;
import com.promiseland.githubclient.R;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by joseph on 2018/1/3.
 */

@Module
public class GithubApiModule {

    @Singleton
    @Provides
    OkHttpClient provideOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if(BuildConfig.DEBUG) {
            builder.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));
        }

        builder.connectTimeout(60 * 1000, TimeUnit.MILLISECONDS)
               .readTimeout(60 * 1000, TimeUnit.MILLISECONDS);

        return builder.build();
    }

    @Singleton
    @Provides
    Retrofit provideRetrofit(Application application, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(application.getString(R.string.endpoint))
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Singleton
    @Provides
    GithubApiService provideGithubApiService(Retrofit retrofit) {
        return retrofit.create(GithubApiService.class);
    }

    @Singleton
    @Provides
    UserManager provideUserManager(GithubApiService githubApiService) {
        return new UserManager(githubApiService);
    }

    @Singleton
    @Provides
    RepositoryManager provideRepositoryManager(GithubApiService githubApiService) {
        return new RepositoryManager(githubApiService);
    }
}

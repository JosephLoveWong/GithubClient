package com.promiseland.githubclient;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by joseph on 2018/1/3.
 */

@Singleton
@Component(modules = {
        AppModule.class
})
public class AppComponent {
}

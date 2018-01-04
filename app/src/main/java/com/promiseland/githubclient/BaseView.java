package com.promiseland.githubclient;

public interface BaseView<T extends BasePresenter> {

    void setPresenter(T presenter);

}

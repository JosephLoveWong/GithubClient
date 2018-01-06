package com.promiseland.githubclient.data;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by joseph on 2018/1/6.
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface UserScope {
}

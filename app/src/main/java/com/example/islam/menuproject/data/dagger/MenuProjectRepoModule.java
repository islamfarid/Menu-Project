package com.example.islam.menuproject.data.dagger;


import com.example.islam.menuproject.data.Remote;
import com.example.islam.menuproject.data.remote.MenuProjectRemoteDataSource;
import com.example.islam.menuproject.data.remote.OkHttp3RemoteDataSource;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by islam on 23/12/16.
 */
@Module
public class MenuProjectRepoModule {
    @Singleton
    @Provides
    @Remote
    MenuProjectRemoteDataSource provideMenuProjectRemoteDataSource() {
        return new OkHttp3RemoteDataSource();
    }

}

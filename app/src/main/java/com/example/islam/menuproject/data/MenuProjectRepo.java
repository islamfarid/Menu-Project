package com.example.islam.menuproject.data;

import com.example.islam.menuproject.data.remote.MenuProjectRemoteDataSource;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.Response;

/**
 * Created by islam on 26/02/17.
 */
@Singleton
public class MenuProjectRepo implements MenuProjectRemoteDataSource {
    private MenuProjectRemoteDataSource menuProjectRemoteDataSource;
    @Inject
    public MenuProjectRepo(@Remote MenuProjectRemoteDataSource menuProjectRemoteDataSource){
        this.menuProjectRemoteDataSource = menuProjectRemoteDataSource;
    }
    @Override
    public Response loadMenuDataStream() throws IOException {
        return menuProjectRemoteDataSource.loadMenuDataStream();
    }
}

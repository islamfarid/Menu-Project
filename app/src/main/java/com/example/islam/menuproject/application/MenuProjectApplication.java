package com.example.islam.menuproject.application;

import android.app.Application;

import com.example.islam.menuproject.data.dagger.DaggerMenuProjectRepoComponent;
import com.example.islam.menuproject.data.dagger.MenuProjectRepoComponent;
import com.example.islam.menuproject.data.dagger.MenuProjectRepoModule;

/**
 * Created by islam on 26/02/17.
 */

public class MenuProjectApplication extends Application{
    private MenuProjectRepoComponent mMenuProjectRepoComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mMenuProjectRepoComponent = DaggerMenuProjectRepoComponent.builder()
                .applicationModule(new ApplicationModule((getApplicationContext()))).menuProjectRepoModule(new MenuProjectRepoModule()).build();
    }

    public MenuProjectRepoComponent getMenuProjectRepoComponent() {
        return mMenuProjectRepoComponent;
    }
}

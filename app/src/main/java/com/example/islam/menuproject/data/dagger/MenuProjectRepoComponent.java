package com.example.islam.menuproject.data.dagger;


import com.example.islam.menuproject.application.ApplicationModule;
import com.example.islam.menuproject.data.MenuProjectRepo;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by islam on 23/12/16.
 */
@Singleton
@Component(modules = {MenuProjectRepoModule.class, ApplicationModule.class})
public interface MenuProjectRepoComponent {
    MenuProjectRepo getMenuProjectRepo();
}

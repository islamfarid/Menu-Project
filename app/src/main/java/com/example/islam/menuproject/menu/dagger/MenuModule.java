package com.example.islam.menuproject.menu.dagger;

import com.example.islam.menuproject.menu.MenuContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by islam on 26/02/17.
 */
@Module
public class MenuModule {
    private final MenuContract.View mView;


    public MenuModule(MenuContract.View view) {
        this.mView = view;
    }

    @Provides
    MenuContract.View provideManufactureView() {
        return mView;
    }
}

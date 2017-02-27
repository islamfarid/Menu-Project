package com.example.islam.menuproject.menu.dagger;

import com.example.islam.menuproject.data.dagger.MenuProjectRepoComponent;
import com.example.islam.menuproject.menu.view.MenuActivity;
import com.example.islam.menuproject.utils.FragmentScoped;

import dagger.Component;

/**
 * Created by islam on 26/02/17.
 */
@FragmentScoped
@Component(dependencies = MenuProjectRepoComponent.class, modules = MenuModule.class)
public interface MenuComponent {
     void inject(MenuActivity menuActivity);
}

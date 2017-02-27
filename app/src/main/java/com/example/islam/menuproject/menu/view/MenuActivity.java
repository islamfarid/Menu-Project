package com.example.islam.menuproject.menu.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.example.islam.menuproject.R;
import com.example.islam.menuproject.application.MenuProjectApplication;
import com.example.islam.menuproject.menu.dagger.DaggerMenuComponent;
import com.example.islam.menuproject.menu.dagger.MenuModule;
import com.example.islam.menuproject.menu.presenter.MenuPresenter;
import com.example.islam.menuproject.utils.ActivityUtils;

import javax.inject.Inject;

public class MenuActivity extends AppCompatActivity {
    WebView webView;
    @Inject
    MenuPresenter menuPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        MenuFragment menuFragment =
                (MenuFragment) getFragmentManager().findFragmentById(R.id.frame_content);
        if (menuFragment == null) {
            // Create the fragment
            menuFragment = MenuFragment.newInstance();
            ActivityUtils.addFragmentToActivity(
                    getFragmentManager(), menuFragment, R.id.frame_content);
        }
        setTitle(getResources().getString(R.string.app_name));
        DaggerMenuComponent.builder()
                .menuProjectRepoComponent(((MenuProjectApplication) getApplication()).getMenuProjectRepoComponent())
                .menuModule(new MenuModule(menuFragment)).build()
                .inject(this);


    }


}

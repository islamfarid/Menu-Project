package com.example.islam.menuproject.menu;


import android.content.Context;

import com.example.islam.menuproject.application.BaseView;

import java.io.InputStream;

import okhttp3.Response;

/**
 * Created by islam on 24/12/16.
 */

public interface MenuContract {
    interface View extends BaseView<Presenter> {
        void showMenuData(String mimeType, String encoding, InputStream menuDataStream);

        void showLoading();

        void showErrorMessage(String errorMsg);

        void hideLoading();

    }

    interface Presenter  {
        String loadLocalData(Context context);
        Response loadMenuData();
    }
}

package com.example.islam.menuproject.menu.presenter;

import android.content.Context;

import com.example.islam.menuproject.menu.MenuContract;
import com.example.islam.menuproject.menu.bussiness.MenuBussiness;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.Response;

/**
 * Created by islam on 26/02/17.
 */

public class MenuPresenter implements MenuContract.Presenter {
    MenuContract.View mView;
    MenuBussiness mMenuBussiness;
    @Inject
    public MenuPresenter(MenuContract.View view){
        this.mView = view;
    }
    @Override
    public String loadLocalData(Context context) {
        return mMenuBussiness.LoadLocalDataFromAssets(context);
    }
    /**
     * Method injection is used here to safely reference {@code this} after the object is created.
     * For more information, see Java Concurrency in Practice.
     */
    @Inject
    public void setupListeners() {
        mView.setPresenter(this);
    }
    @Override
    public Response loadMenuData() {
        mView.showLoading();
        try {
            return mMenuBussiness.LoadMenuData();
        } catch (IOException e) {
            mView.showErrorMessage(e.getMessage());
        }
        finally {
            mView.hideLoading();
        }
        return null;
    }
    @Inject
    public void setmMenuBussiness(MenuBussiness menuBussiness){
        this.mMenuBussiness = menuBussiness;
    }
}

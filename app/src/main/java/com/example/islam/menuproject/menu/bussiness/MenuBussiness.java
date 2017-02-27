package com.example.islam.menuproject.menu.bussiness;

import android.content.Context;

import com.example.islam.menuproject.common.Constants;
import com.example.islam.menuproject.data.MenuProjectRepo;
import com.example.islam.menuproject.utils.FileUtils;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.Response;

/**
 * Created by islam on 26/02/17.
 */

public class MenuBussiness {
    @Inject
    MenuProjectRepo mMenuProjectRepo;

    @Inject
    public MenuBussiness() {

    }

    public String LoadLocalDataFromAssets(Context context) {
        return FileUtils.readAssetFileAsString(context, Constants.MENU_HTML);
    }

    public Response LoadMenuData() throws IOException {
        Response response = mMenuProjectRepo.loadMenuDataStream();
        if(response != null){
            return response;
        }else {
            throw new IOException();
        }
    }
}

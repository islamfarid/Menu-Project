package com.example.islam.menuproject.data.remote;

import com.example.islam.menuproject.common.Constants;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by islam on 26/02/17.
 */

public class OkHttp3RemoteDataSource implements MenuProjectRemoteDataSource {
    @Override
    public Response loadMenuDataStream() throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();
        final Call call = okHttpClient.newCall(new Request.Builder()
                .url(Constants.MENU_DATA_URL)
                .build()
        );

        final Response response = call.execute();
        return response;
    }
}

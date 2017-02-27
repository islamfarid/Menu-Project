package com.example.islam.menuproject.data.remote;


import java.io.IOException;

import okhttp3.Response;


/**
 * Created by islam on 14/01/17.
 */

public interface MenuProjectRemoteDataSource {
    Response loadMenuDataStream() throws IOException;
}

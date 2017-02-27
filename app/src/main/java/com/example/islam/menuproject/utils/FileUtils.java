package com.example.islam.menuproject.utils;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by islam on 26/02/17.
 */

public class FileUtils {
    public static String readAssetFileAsString(Context context, String sourceHtmlLocation) {
        InputStream inputStream;
        try {
            inputStream =context.getAssets().open(sourceHtmlLocation);
            int size = inputStream.available();

            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();

            return new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }
}

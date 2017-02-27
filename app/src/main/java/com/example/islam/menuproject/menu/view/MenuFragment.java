package com.example.islam.menuproject.menu.view;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.example.islam.menuproject.R;
import com.example.islam.menuproject.menu.MenuContract;

import java.io.InputStream;

import okhttp3.Response;

/**
 * Created by islam on 26/02/17.
 */

public class MenuFragment extends Fragment implements MenuContract.View {
    MenuContract.Presenter mMenuPresenter;
    private WebView mWebView;
    private ProgressBar mProgressBar;


    public static MenuFragment newInstance() {
        return new MenuFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_menu, container, false);
        setHasOptionsMenu(true);
        setRetainInstance(true);
        mProgressBar = (ProgressBar)root.findViewById(R.id.progressBar);
        mWebView = (WebView) root.findViewById(R.id.wb_menu);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setDomStorageEnabled(true);
        mWebView.getSettings(). setAllowUniversalAccessFromFileURLs(true);
        mWebView.setWebChromeClient(new WebChromeClient());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            mWebView.setWebContentsDebuggingEnabled(true);
        }
        mWebView.setWebViewClient(new WebViewClient() {

            @Override
            public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
                    final Response response = mMenuPresenter.loadMenuData();
                if(response != null) {
                    WebResourceResponse webResourceResponse = new WebResourceResponse(
                            response.header("content-type", "application/json"), // You can set something other as default content-type
                            response.header("content-encoding", "utf-8")  // Again, you can set another encoding as default

                            , response.body().byteStream()
                    );
                    return  webResourceResponse;
                }else {
                   return null;
                }

            }
        });
        mWebView.loadDataWithBaseURL("file:///android_asset", mMenuPresenter.loadLocalData(getActivity()), "text/html", "UTF-8", null);
        return root;
    }
    @Override
    public void showMenuData(String mimeType, String encoding, InputStream menuDataStream) {

    }



    @Override
    public void showLoading() {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mProgressBar.setVisibility(View.VISIBLE);
            }
        });

    }

    @Override
    public void showErrorMessage(final String errorMsg) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Snackbar.make(mWebView, errorMsg, Snackbar.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public void hideLoading() {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mProgressBar.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public void setPresenter(MenuContract.Presenter presenter) {
        this.mMenuPresenter = presenter;
    }
}

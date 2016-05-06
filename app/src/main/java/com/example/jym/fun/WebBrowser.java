package com.example.jym.fun;

/**
 * Created by Machenike-Pc on 2016/4/25.
 */

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class WebBrowser extends Activity implements OnClickListener{
    EditText url;
    WebView mWebView;
    Button goButton;
    Button backButton;
    Button homeButton;
    Button blogButton;
    private long exitTime = 0;
    AlertDialog builder;
    void showurl(){
        String currenturl=mWebView.getUrl();
        url.setText(currenturl);

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.webbrowser);
        setControl();
        setWebStyle();
    }
    @Override
    public void onBackPressed() {
        if (mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Toast.makeText(getApplicationContext(), "再按一次退出程序",
                        Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                super.onBackPressed();
            }

        }
    }
    private void setControl() {
        url=(EditText)findViewById(R.id.urltext);
        mWebView=(WebView)findViewById(R.id.webshow);
        goButton=(Button)findViewById(R.id.GoBtn);
        backButton=(Button)findViewById(R.id.BackBtn);
        homeButton=(Button)findViewById(R.id.HomeBtn);
        blogButton= (Button) findViewById(R.id.blogBtn);
        blogButton.setOnClickListener(this);
        goButton.setOnClickListener(this);
        backButton.setOnClickListener(this);
        homeButton.setOnClickListener(this);

    }
    private void setWebStyle() {
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setSupportZoom(true);
        mWebView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        mWebView.requestFocus();
        mWebView.loadUrl("http://www.baidu.com/");
        mWebView.setWebViewClient(new MyWebViewClient());

    }
    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch(v.getId()){
            case R.id.GoBtn:
                String url_text;
                String url_head = "http://";
                url_text=url.getText().toString();
                if(!url_text.contains("http://")){
                    url_text=url_head.concat(url_text);
                }
                mWebView.loadUrl(url_text);
                break;
            case R.id.BackBtn:
                builder=new AlertDialog.Builder(this).setTitle("退出浏览器").setIcon(R.drawable.web).setMessage("确定退出浏览器么？").setNegativeButton(
                        "取消",new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                }).create();
                builder.show();
                break;
            case R.id.HomeBtn:
                mWebView.loadUrl("https://www.baidu.com/");
               showurl();
                break;
            case R.id.blogBtn:
                mWebView.loadUrl("http://www.cnblogs.com/jymblog/");
                showurl();
        }
    }


    class MyWebViewClient extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view,String url_){
            view.loadUrl(url_);
            url.setText(url_);
            return true;
        }
    }
}


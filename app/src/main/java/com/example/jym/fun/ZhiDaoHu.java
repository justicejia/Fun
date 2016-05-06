package com.example.jym.fun;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;

import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Machenike-Pc on 2016/4/20.
 */

public class ZhiDaoHu extends Activity {
   private DrawerLayout mDrawLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//无标题
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);  //全屏
        setContentView(R.layout.zhidaohu);
        mDrawLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        AdapterView listView=(ListView)findViewById(R.id.left_drawer);
        TextView tv_begin=(TextView)findViewById(R.id.menu_right);
        tv_begin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.menu_right:
                        mDrawLayout.openDrawer(Gravity.LEFT);
                }

            }
        });
        final TextView tv=(TextView)findViewById(R.id.content_right);
        tv.setText("请选择左侧");
        String[] array=new String[]{"首页","发现","关注","收藏"};
        ArrayAdapter<String> adapter1=new ArrayAdapter<String>(this,R.layout.zdh_left,array);
        listView.setAdapter(adapter1);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0: {
                        tv.setText("这是首页");
                        break;
                    }
                    case 1: {
                        tv.setText("这是发现");
                        break;
                    }
                    case 2: {
                        tv.setText("这是关注");
                        break;
                    }
                    case 3: {
                        tv.setText("这是收藏");
                        break;
                    }


                }
            }
        });

    setWindowStatus();
    }

    private void setWindowStatus(){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT){
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

        }
    }



}

package com.example.jym.fun;

import android.app.Fragment;
import android.content.Intent;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import java.util.HashMap;

/**
 * Created by Machenike-Pc on 2016/4/14.
 */
public class Tab1 extends Fragment {
    private SoundPool soundPool;
    HashMap<Integer,Integer> soundMap=new HashMap<>();
    Button bn1,bn2,bn3,bn4,bn5,bn6,bn7;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_1,container,false);
        ViewFlipper vf=(ViewFlipper)view.findViewById(R.id.vf);
        vf.setAutoStart(true);
        vf.setFlipInterval(2500);
        //打开绘图板
       TextView tv_drawplate=(TextView)view.findViewById(R.id.drawplate);
        tv_drawplate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Plate.class);//牛逼啊，终于解决了，用getActivity!!
                startActivity(intent);
            }
        });
        //打开知道乎
        TextView tv_zhihu=(TextView)view.findViewById(R.id.zhidaohu);
        tv_zhihu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),ZhiDaoHu.class);
                startActivity(intent);
            }
        });
        //打开记事本
        TextView tv_mynote=(TextView)view.findViewById(R.id.mynote);
        tv_mynote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),MyNote.class);
                startActivity(intent);
            }
        });
        //打开浏览器
        TextView tv_web=(TextView)view.findViewById(R.id.webbrowser);
        tv_web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),WebBrowser.class);
                startActivity(intent);
            }
        });
        //为钢琴设置按键监听器
        bn1=(Button)view.findViewById(R.id.piano_1);
        bn2=(Button)view.findViewById(R.id.piano_2);
        bn3=(Button)view.findViewById(R.id.piano_3);
        bn4=(Button)view.findViewById(R.id.piano_4);
        bn5=(Button)view.findViewById(R.id.piano_5);
        bn6=(Button)view.findViewById(R.id.piano_6);
        bn7=(Button)view.findViewById(R.id.piano_7);
        setpiano();

        //返回view
        return view;
    }

    //设置钢琴
    private void setpiano(){
        soundPool=new SoundPool(7,0,5);
        soundMap.put(1,soundPool.load(getActivity(),R.raw.dao,1));
        soundMap.put(2,soundPool.load(getActivity(),R.raw.re,1));
        soundMap.put(3,soundPool.load(getActivity(),R.raw.mi,1));
        soundMap.put(4,soundPool.load(getActivity(),R.raw.fa,1));
        soundMap.put(5,soundPool.load(getActivity(),R.raw.sao,1));
        soundMap.put(6,soundPool.load(getActivity(),R.raw.la,1));
        soundMap.put(7,soundPool.load(getActivity(),R.raw.xi,1));
        //下面给所有的钢琴键赋上监听器
        bn1.setOnClickListener(onClickListener);
        bn2.setOnClickListener(onClickListener);
        bn3.setOnClickListener(onClickListener);
        bn4.setOnClickListener(onClickListener);
        bn5.setOnClickListener(onClickListener);
        bn6.setOnClickListener(onClickListener);
        bn7.setOnClickListener(onClickListener);

    }
    //设置钢琴的监听器
    View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId())
            {
                case R.id.piano_1:
                    soundPool.play(soundMap.get(1),1,1,0,0,1);
                case R.id.piano_2:
                    soundPool.play(soundMap.get(2),1,1,0,0,1);
                case R.id.piano_3:
                    soundPool.play(soundMap.get(3),1,1,0,0,1);
                case R.id.piano_4:
                    soundPool.play(soundMap.get(4),1,1,0,0,1);
                case R.id.piano_5:
                    soundPool.play(soundMap.get(5),1,1,0,0,1);
                case R.id.piano_6:
                    soundPool.play(soundMap.get(6),1,1,0,0,1);
                case R.id.piano_7:
                    soundPool.play(soundMap.get(7),1,1,0,0,1);

            }
        }
    };
}



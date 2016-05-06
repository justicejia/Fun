package com.example.jym.fun;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/**
 * Created by Machenike-Pc on 2016/4/18.
 */
public class Plate extends Activity {

    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.platedraw);
        final View view = findViewById(R.id.plate);
        Button bnred = (Button) findViewById(R.id.red);
        Button bnblue = (Button) findViewById(R.id.blue);
        Button bngreen = (Button) findViewById(R.id.green);

       bnred.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.RED);
            }
        });
        bnblue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(Color.BLUE);
            }
        });
        bngreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {view.setBackgroundColor(Color.GREEN);
            }
        });
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        menu.add(0, 0x111, 0, "红色");
//        menu.add(0, 0x112, 0, "蓝色");
//        menu.add(0, 0x113, 0, "绿色");
//        return true;
//    }
//
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case 0x111:
//                item.setCheckable(true);
//                view.setBackgroundColor(Color.RED);
//                break;
//            case 0x112:
//                item.setCheckable(true);
//                view.setBackgroundColor(Color.BLUE);
//                break;
//            case 0x113:
//                item.setCheckable(true);
//                view.setBackgroundColor(Color.GREEN);
//                break;
//        }
//        return true;
//    }

}

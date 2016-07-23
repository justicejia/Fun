package com.example.jym.fun;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView Text_Tab1;
    private TextView Text_Tab2;
    private TextView Text_Tab3;
    private TextView Text_Tab4;
    private Tab1 mTab1;
    private Tab2 mTab2;
    private Tab3 mTab3;
    private Tab4 mTab4;
    ActionBar actionBar;
    private FragmentManager fManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        fManager=getFragmentManager();
        bindViews();
        Text_Tab1.performClick();
        actionBar=getActionBar();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=new MenuInflater(this);
        inflater.inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Intent intent = new Intent(this, SetActivity.class);
                startActivity(intent);
                break;
        }
        return true;
    }
    //    @Override
//    public boolean onOptionItemselected(MenuItem mi)
//    {
//        switch (mi.getItemId()){
//            case R.id.action_settings:
//                Intent intent=new Intent(this,SetActivity.class);
//                startActivity(intent);
//                break;
//        }
//        return true;
//    }

    private void bindViews(){
        Text_Tab1=(TextView)findViewById(R.id.tab1);
        Text_Tab2=(TextView)findViewById(R.id.tab2);
        Text_Tab3=(TextView)findViewById(R.id.tab3);
        Text_Tab4=(TextView)findViewById(R.id.tab4);
        Text_Tab1.setOnClickListener(this);
        Text_Tab2.setOnClickListener(this);
        Text_Tab3.setOnClickListener(this);
        Text_Tab4.setOnClickListener(this);

    }
    private void setSelct(){
        Text_Tab1.setSelected(false);
        Text_Tab2.setSelected(false);
        Text_Tab3.setSelected(false);
        Text_Tab4.setSelected(false);
    }
    private void hideAllFragment(FragmentTransaction fragmentTransaction) {
        if (mTab1 != null) fragmentTransaction.hide(mTab1);
        if (mTab2 != null) fragmentTransaction.hide(mTab2);
        if (mTab3 != null) fragmentTransaction.hide(mTab3);
        if (mTab4 != null) fragmentTransaction.hide(mTab4);
    }

    @Override
    public void onClick(View v) {
        FragmentTransaction ftransaction=fManager.beginTransaction();
        hideAllFragment(ftransaction);
       switch (v.getId()){
           case R.id.tab1:
               setSelct();
               Text_Tab1.setSelected(true);
           {
               if(mTab1 == null){
                   mTab1 = new Tab1();

                   ftransaction.add(R.id.ly_content,mTab1);
               }else{
                   ftransaction.show(mTab1);
               }
               break;
           }
           case R.id.tab2:
               setSelct();
               Text_Tab2.setSelected(true);
           {
               if(mTab2 == null){
                   mTab2 = new Tab2();
                   ftransaction.add(R.id.ly_content,mTab2);
               }else{
                   ftransaction.show(mTab2);
               }
               break;
           }
           case R.id.tab3:
               setSelct();
               Text_Tab3.setSelected(true);
           {
               if(mTab3 == null){
                   mTab3 = new Tab3();
                   ftransaction.add(R.id.ly_content,mTab3);
               }else{
                   ftransaction.show(mTab3);
               }
               break;
           }
           case R.id.tab4:
               setSelct();
               Text_Tab4.setSelected(true);
           {
               if(mTab4 == null){
                   mTab4 = new Tab4();
                   ftransaction.add(R.id.ly_content,mTab4);
               }else{
                   ftransaction.show(mTab4);
               }
               break;
           }


       }
        ftransaction.commit();
    }

}

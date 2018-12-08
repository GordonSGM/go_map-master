package com.example.go_map;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;

import fragment_class.map_class;
import fragment_class.myself_class;
import fragment_class.recommend_class;

public class MainUIActivity extends FragmentActivity{
    private Button map=null;
    private Button recommend=null;
    private Button myself=null;
    private boolean TOF=false;
    private Fragment mFragment=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ui);
        //----初始化界面-----
        if(!TOF)
        {
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            map_class mapClass= new map_class();
            transaction.add(R.id.fragment_container, mapClass);  //容器即FragmentLayout
            transaction.commit();
            mFragment=mapClass;
            TOF=true;
        }
        //-------
        map=(Button)findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                map_class mapClass= new map_class();
                transaction.remove(mFragment);
                transaction.add(R.id.fragment_container, mapClass);  //容器即FragmentLayout
                transaction.commit();
                if(mFragment!=mapClass)
                    mFragment=mapClass;
            }
        });
        recommend=(Button)findViewById(R.id.recommend);
        recommend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                recommend_class recommendClass= new recommend_class();
                transaction.remove(mFragment);
                transaction.add(R.id.fragment_container, recommendClass);  //容器即FragmentLayout
                transaction.commit();
                if(mFragment!=recommendClass)
                    mFragment=recommendClass;
            }
        });

        myself=(Button)findViewById(R.id.myself);
        myself.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                myself_class myselfClass= new myself_class();
                transaction.remove(mFragment);
                transaction.add(R.id.fragment_container, myselfClass);  //容器即FragmentLayout
                transaction.commit();
                if(mFragment!=myselfClass)
                    mFragment=myselfClass;
            }
        });
    }
}

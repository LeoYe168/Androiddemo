package com.leoye.androiddemo.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;

import com.leoye.androiddemo.R;

import java.util.List;

public class RecyclerViewActivity extends FragmentActivity {


    private RecyclerView recyclerView;
    private List<String> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        // recyclerView.setAdapter();
    }


    private void initDatas() {

    }
}



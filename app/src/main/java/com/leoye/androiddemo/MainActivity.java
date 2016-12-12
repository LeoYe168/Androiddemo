package com.leoye.androiddemo;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity implements View.OnClickListener {
    String[] items = {
            "Design Support Library demo", "ReclelyView Demo","About listview"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_expandable_list_item_1,
                items));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent intent = new Intent();
        switch (position) {
            case 0:
                intent.setClass(MainActivity.this, MaterialDesignActivity.class);
                startActivity(intent);
                break;
            case 1:
                intent.setClass(MainActivity.this, MaterialDesignActivity.class);
                startActivity(intent);
                break;
        }
    }


    @Override
    public void onClick(View v) {

    }

}



package com.leoye.androiddemo.activity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.leoye.androiddemo.R;
import com.leoye.androiddemo.util.ShareUtil;

public class MainActivity extends ListActivity implements View.OnClickListener {
    String[] items = {
            "Design Support Library Demo", "recyclerview Demo", "Share intent Demo"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setListAdapter(new ArrayAdapter<>(this,
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
                intent.setClass(MainActivity.this, RecyclerViewActivity.class);
                startActivity(intent);
                break;

            case 2:
                ShareUtil.shareDialog(MainActivity.this, "share title", null, "share text", "share objeck", "share link", "share imageUrl");
                Toast.makeText(MainActivity.this, "share intent demo", Toast.LENGTH_SHORT).show();
                break;
        }
    }


    @Override
    public void onClick(View v) {

    }

}



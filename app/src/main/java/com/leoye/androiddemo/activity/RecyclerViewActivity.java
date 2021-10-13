package com.leoye.androiddemo.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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
        recyclerView.setAdapter(new RecyclerView.Adapter() {
            @NonNull
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                RecyclerView.ViewHolder holder = null;
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_share_list, null);
                holder = new ViewHolder(v);
                return holder;
            }

            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

            }

            @Override
            public int getItemCount() {
                return 9;
            }
        });
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv_lock;
        private TextView tv_title;

        public ViewHolder(View itemView) {
            super(itemView);
            iv_lock = (ImageView) itemView.findViewById(R.id.shareImage);
            tv_title = (TextView) itemView.findViewById(R.id.shareName);
        }
    }

    private void initDatas() {

    }
}



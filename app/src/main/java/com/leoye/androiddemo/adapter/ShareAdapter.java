package com.leoye.androiddemo.adapter;

import android.app.Activity;
import android.content.pm.ResolveInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.leoye.androiddemo.R;


/**
 * Created by yeyao on 17/4/5 下午4:21
 */
public class ShareAdapter extends ArrayAdapter {

    private final Activity context;
    Object[] items;


    public ShareAdapter(Activity context, Object[] items) {
        super(context, R.layout.item_share_list, items);
        this.context = context;
        this.items = items;

    }// end HomeListViewPrototype

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();

        View rowView = inflater.inflate(R.layout.item_share_list, null, true);

        // set share name
        TextView shareName = (TextView) rowView.findViewById(R.id.shareName);

        // Set share image
        ImageView imageShare = (ImageView) rowView.findViewById(R.id.shareImage);
        if (items[position] != null) {
            // set native name of App to share
            shareName.setText(((ResolveInfo) items[position]).activityInfo.loadLabel(context.getPackageManager()).toString());

            // share native image of the App to share
            imageShare.setImageDrawable(((ResolveInfo) items[position]).activityInfo.applicationInfo.loadIcon(context.getPackageManager()));
        } else {
            shareName.setText("Others");
        }


        return rowView;
    }// end getView
}

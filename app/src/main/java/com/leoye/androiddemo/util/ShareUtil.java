package com.leoye.androiddemo.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.leoye.androiddemo.adapter.ShareAdapter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Leoye168 on 2017/4/11 下午2:17
 */

public class ShareUtil {
    /**
     * @param context
     * @param title
     * @param uri
     * @param shareText
     * @param shareSubject
     * @param shareLink
     * @param imageUrl
     */

    public static void shareDialog(final Context context, final String title, final Uri uri, final String shareText, final String shareSubject, final String shareLink, final String imageUrl) {

        final BottomSheetDialog sheetDialog = new BottomSheetDialog(context);
        ListView listView = new ListView(context);
        final List<List<ResolveInfo>> arrayList = getShareActivities(context);
        ShareAdapter bottomProductsAdapter = new ShareAdapter((Activity) context, arrayList.get(0).toArray());
        listView.setAdapter(bottomProductsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(android.content.Intent.ACTION_SEND);
                ResolveInfo info = arrayList.get(0).get(position);
                if (info != null) {
                    if (info.activityInfo.packageName.equals("com.facebook.katana")) {
                        Toast.makeText(context, "Facebook sharing needs to be handled separately", Toast.LENGTH_SHORT).show();
//Facebook sharing needs to be handled separately,as follow the code

//                        facebook分享需要imageUrl参数，避免因接口未返回该参数而不能分享，设置一个默认的ezbuy logo图片
//                        String imageUrl1 = TextUtils.isEmpty(imageUrl) ? "http://c93fea60bb98e121740fc38ff31162a8.s3.amazonaws.com/wp-content/uploads/2016/03/ezbuy.png" : imageUrl;
//                        //facebook分享单独处理
//                        ShareLinkContent shareLinkContent = new ShareLinkContent.Builder()
//                                .setContentTitle(title)
//                                .setContentDescription(shareText)
//                                .setContentUrl(Uri.parse(shareLink))
//                                .setImageUrl(Uri.parse(imageUrl1))
//                                .build();
//                        ShareDialog.show((Activity) context, shareLinkContent);
                    } else {
                        intent.setClassName(info.activityInfo.packageName, info.activityInfo.name);
                        intent.setType("text/plain");
                        if (uri != null) {
                            intent.setType("image/*");
                            intent.putExtra(Intent.EXTRA_STREAM, uri);
                        }
                        intent.putExtra(Intent.EXTRA_SUBJECT, shareSubject);
                        intent.putExtra(Intent.EXTRA_TEXT, shareText + "#" + shareLink);
                        context.startActivity(intent);
                    }
                } else {
                    //选择other 跳转系统分享列表页面
                    ShareUtil.openShareDialog(arrayList.get(1), context, title, uri, shareText, shareSubject);
                }
                sheetDialog.dismiss();
            }
        });

        sheetDialog.setContentView(listView);
        View view1 = sheetDialog.getDelegate().findViewById(android.support.design.R.id.design_bottom_sheet);
        final BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from(view1);
        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if (newState == BottomSheetBehavior.STATE_HIDDEN) {
                    sheetDialog.dismiss();
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });
        sheetDialog.show();
    }

    private static List<List<ResolveInfo>> getShareActivities(Context context) {
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        PackageManager pm = context.getPackageManager();
        List<List<ResolveInfo>> listArrayList = new ArrayList<>();
        List<ResolveInfo> activityList = pm.queryIntentActivities(sharingIntent, 0);
        List<ResolveInfo> newActivityList = new ArrayList<>();

        for (Iterator<ResolveInfo> it = activityList.iterator(); it.hasNext(); ) {
            ResolveInfo info = it.next();
            //过滤出facebook google+  whatsapp  分享app单独处理
            if (info.activityInfo.packageName.equals("com.facebook.katana") || info.activityInfo.packageName.equals("com.google.android.apps.plus") || info.activityInfo.packageName.equals("com.facebook.orca") || info.activityInfo.packageName.contains("whatsapp")) {
                it.remove();
                newActivityList.add(info);
            }
        }
        //增加一条other数据
        newActivityList.add(null);
        listArrayList.add(newActivityList);
        listArrayList.add(activityList);
        return listArrayList;
    }

    /**
     * android system to provide the way to share
     *
     * @param context
     * @param title
     * @param uri
     * @param shareText
     */
    public static void openShareDialog(List<ResolveInfo> packages, Context context, String title, Uri uri, String shareText, String shareSubject) {
        List<Intent> targetIntents = new ArrayList<Intent>();
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        for (ResolveInfo candidate : packages) {
            String packageName = candidate.activityInfo.packageName;
            Intent target = new Intent(android.content.Intent.ACTION_SEND);
            target.setType("text/plain");
            if (uri != null) {
                shareIntent.setType("image/*");
                shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
            }
            target.putExtra(Intent.EXTRA_TEXT, shareText);
            target.setPackage(packageName);
            targetIntents.add(target);
        }
        Intent chooserIntent = Intent.createChooser(targetIntents.remove(0), title);
        chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, targetIntents.toArray(new Parcelable[]{}));
        context.startActivity(chooserIntent);

    }

}

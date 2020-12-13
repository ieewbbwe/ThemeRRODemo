package com.example.target.widget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyWidget extends AppWidgetProvider {

    String TAG = "MyWidget：" ;
    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        Log.i(TAG ,"接受广播");
    }

    /**
     * 第一个widget被添加调用
     * @param context
     */
    @Override
    public void onEnabled(Context context) {
        super.onEnabled(context);
        Log.i(TAG ,"widget  onEnabled 状态");
        context.startService(new Intent(context, WidgetService.class));

    }

    /**
     * widget被添加 || 更新时调用
     * @param context
     */
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        Log.i(TAG ,"widget  onUpdate 状态");
        context.startService(new Intent(context, WidgetService.class));
    }

    /**
     * 最后一个widget被删除时调用
     * @param context
     */
    @Override
    public void onDisabled(Context context) {
        super.onDisabled(context);
        Log.i(TAG ,"widget  onDisabled 状态");
        context.stopService(new Intent(context, WidgetService.class));
    }

    /**
     * widget被删除时调用
     * @param context
     * @param appWidgetIds
     */
    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        super.onDeleted(context, appWidgetIds);
        Log.i(TAG ,"widget  onDeleted 状态");

    }
}

package com.example.target.widget;

import android.app.PendingIntent;
import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.RemoteViews;

import androidx.annotation.Nullable;

import com.example.target.MainActivity;
import com.example.target.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class WidgetService extends Service {


    String TAG = "WidgetService ";
    private Timer mTimer;
    private SimpleDateFormat mFormat;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "onBind");
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        mTimer = new Timer();
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                Log.i(TAG, "更新 widget");
                updateWidget(WidgetService.this);  //更新 widget
            }
        }, 0, 1000);

    }

    private void updateWidget(Context context) {

        //通过 RemoteViews 加载布局文件
        //通过 setTextView 等方法实现对控件的控制
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget_layout);
        long millis = System.currentTimeMillis();
        String format = mFormat.format(new Date(millis));
        Log.i(TAG, "millis :" + millis + "\n"
                + "format: " + format);
        remoteViews.setTextViewText(R.id.tv_date, "日  期：" + format+"毫秒值：" + millis);

        PendingIntent pendingIntent = PendingIntent
                .getActivity(context, 0, new Intent(this, MainActivity.class), PendingIntent.FLAG_UPDATE_CURRENT);
        remoteViews.setOnClickPendingIntent(R.id.btn_refound, pendingIntent);   //点击跳转

        ComponentName componentName = new ComponentName(this, MyWidget.class);
        AppWidgetManager.getInstance(this).updateAppWidget(componentName, remoteViews);

    }


    @Override
    public void onDestroy() {
        super.onDestroy();

        mTimer.cancel();
        mTimer = null;
        Log.i(TAG, "onDestory");
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }
}

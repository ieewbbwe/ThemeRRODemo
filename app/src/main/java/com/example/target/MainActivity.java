package com.example.target;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("picheffrtag", "onCreate");
        Log.d("pichertag", "ActivityHash："+ hashCode()+"ApplicationHash："+getApplication().hashCode());
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("pichertag", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("pichertag", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("pichertag", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("pichertag", "onStop");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("pichertag", "onNewIntent");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("pichertag", "onDestroy");
    }
}

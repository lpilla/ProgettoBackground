package com.example.progettobackground.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyService extends Service {
    private Boolean isRunning = false;
    private int count = 0;

    public int onStartCommand(Intent intent,int flags,int startId) {
        isRunning = true;
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        while(isRunning){
                            count ++;
                            Log.e("MyService","Service is running..."+count);
                            try{
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
        ).start();

        return super.onStartCommand(intent,flags,startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.isRunning = false;
        this.count = 0;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}

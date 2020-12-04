package com.fomin.service_lab3;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;

public class MusicService extends Service {

    static MediaPlayer nokiaPlayer, hmm3Player, xpPlayer;

    public class MusicServiceBinder extends Binder {
        public MusicService getService(){
            return MusicService.this;
        }
    }
    @Override
    public IBinder onBind(Intent intent) {
        return new MusicServiceBinder();
    }
    @Override
    public void onCreate(){

        nokiaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.nokia);
        hmm3Player = MediaPlayer.create(getApplicationContext(), R.raw.homam3_novaya_nedelya);
        xpPlayer = MediaPlayer.create(getApplicationContext(), R.raw.vkl_xp);
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        nokiaPlayer.release();
        hmm3Player.release();
        xpPlayer.release();
        super.onDestroy();
    }
    public static void playFirst(){
        nokiaPlayer.start();
    }
    public static void playSecond(){
        hmm3Player.start();
    }
    public static void playThird(){
        xpPlayer.start();
    }

}
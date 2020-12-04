package com.fomin.service_lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MusicService musicService;
    private boolean isBound = false;
    final private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName className, IBinder service) {
            MusicService.MusicServiceBinder binder = (MusicService.MusicServiceBinder) service;
            musicService = binder.getService();
            isBound = true;
        }
        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            isBound = false;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, MusicService.class);
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }
    @Override
    protected void onStop() {
        super.onStop();
        unbindService(serviceConnection);
        isBound = false;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.nav_menu, menu);
        return true;
    }
    @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        TextView description = (TextView) findViewById(R.id.description);
        switch(id){
            case R.id.first_song :
                description.setText("Best phone");
                MusicService.playFirst();
                return true;
            case R.id.second_song:
                description.setText("Great game");
                MusicService.playSecond();
                return true;
            case R.id.third_song:
                description.setText("First OS in my life");
                MusicService.playThird();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
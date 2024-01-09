package com.example.progettobackground;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;

import com.example.progettobackground.databinding.ActivityMainBinding;
import com.example.progettobackground.services.MyService;

public class MainActivity extends AppCompatActivity {
    protected ActivityMainBinding binding;
    private States states = new States();
    private Intent myServiceIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        myServiceIntent = new Intent(MainActivity.this, MyService.class);
        binding.startButton.setOnClickListener(v -> {
            Log.d("Service Started: ", states.isStarted().toString());
            states.setStarted(!states.isStarted());
            if(states.isStarted()){
                startService(myServiceIntent);
            } else {
                Log.d("Service stopped","si");
                stopService(myServiceIntent);
            }
        });
    }
}
package com.example.fan.demo;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import communication.UtilMethods;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        handler = new Handler(){
            @Override
            public void handleMessage(Message msg){

            }
        };


        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               UtilMethods.get_all_notification(handler);
            }
        });

    }
}

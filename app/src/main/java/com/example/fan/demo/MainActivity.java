package com.example.fan.demo;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import communication.UtilMethods;

public class MainActivity extends Activity {

    private Button button;
    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler = new Handler(){
            @Override
            public void handleMessage(Message msg){
                int recode = msg.arg1;
                List list = (List) msg.obj;
                for(int i=0;i<list.size();i++){
                    Map<String, Object> map = (Map<String, Object>) list.get(i);
                    System.out.println(map.get("id"));
                    System.out.println(map.get("title"));
                    System.out.println(map.get("content"));
                    System.out.println(map.get("publishDate"));
                    System.out.println(map.get("sender"));

                }

            }
        };

        button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               UtilMethods.User.get_all_notifications(handler);
            }
        });


    }
}

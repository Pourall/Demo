package com.example.fan.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import communication.entities.Notification;
import communication.UtilMethods;

public class MainActivity extends AppCompatActivity {

    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> list = new ArrayList<String>();
                list.add("hahah");
                list.add("sdfsd");
                Notification notification =new Notification();
                notification.setId("123");
                notification.setTitle("haah");
                notification.setContent("hjhkjsh");
                notification.setPubliishDate(new Date());
                notification.setSender("dddd");
                notification.setReceivers(list);
                System.out.println(UtilMethods.toJSON(notification));
            }
        });

    }
}

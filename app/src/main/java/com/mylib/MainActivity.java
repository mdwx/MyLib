package com.mylib;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {
    private TextView tv_message;
    private Button bt_message;
    private Button bt_bind;

    int i =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_message=(TextView)this.findViewById(R.id.textView);
        bt_message=(Button)this.findViewById(R.id.sendmessage);
        bt_bind=(Button)this.findViewById(R.id.button);

        bt_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SecondActivity.class));
            }
        });

        bt_bind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().unregister(MainActivity.this);
                EventBus.getDefault().register(MainActivity.this);
            }
        });

    }
   @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMoonEvent(MessageEvent messageEvent){
        i++;
        tv_message.setText(messageEvent.getMessage()+i);

    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMoonEvent2(MessageEvent messageEvent){
        i++;
        tv_message.setText(messageEvent.getMessage()+"onMoonEvent2"+i);
    }
    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void onMoonEvent3(MessageEvent messageEvent){
        i++;
        tv_message.setText(messageEvent.getMessage()+"onMoonEvent3"+i);
    }
}


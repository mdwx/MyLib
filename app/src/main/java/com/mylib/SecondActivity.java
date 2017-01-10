package com.mylib;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;

import base.MessageEvent;

/**
 * Created by Arales on 2016/8/22.
 * E_mail :  xhys01@163.com
 * Description :
 */
public class SecondActivity extends AppCompatActivity {
    private Button bt_message;
    private Button bt_message2;
    private TextView tv_message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv_message=(TextView)this.findViewById(R.id.textView2);

        tv_message.setText("SecondActivity");
        bt_message=(Button)this.findViewById(R.id.sendmessage2);
        bt_message.setText("Send Message");

        bt_message2=(Button)this.findViewById(R.id.button2);
        bt_message.setText("Send sticky Message");
        bt_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new MessageEvent("Welcome!!!"));
                finish();
            }
        });
        bt_message2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().postSticky(new MessageEvent("postSticky!!!"));
                EventBus.getDefault().postSticky(new MessageEvent("postSticky2!!!"));
                EventBus.getDefault().postSticky(new MessageEvent("postSticky3!!!"));
                EventBus.getDefault().postSticky(new MessageEvent("postSticky4!!!"));
                finish();
            }
        });

    }
}

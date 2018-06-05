package com.hc.routera;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.hc.baseconnection.Test.User;
import com.hc.baseconnection.callback.ConnectionCallback;
import com.hc.baseconnection.router.Request.RouterRequest;

import java.util.ArrayList;
import java.util.List;


public class RouterActivity extends AppCompatActivity {
    public static final String TAG = "RouterActivity";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routera);
        findViewById(R.id.btn_action).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    RouterRequest request = RouterRequest.getBuilder(RouterActivity.this)
                            .provider("TestProvider")
                            .action("TestAction")
                            .data(RouterActivity.this)
                            .build();

                    //提供方会在建立Action时提供此Action是否时线程同步，供调用方调用时逻辑判断
                    if (request.getAction().isAsync()) {
                        request.excute();
                    } else {
                        //异步操作 data返回也要跟随异步
                    }

                } catch (Exception e) {
                    Log.i(TAG, "doAction  : " + e.getMessage());
                }
            }
        });


        findViewById(R.id.btn_action_callback).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doAction1();
            }
        });
    }



    private void doAction1() {
        try {
            List<User> list = new ArrayList<User>();
            list.add(new User("Test1"));
            list.add(new User("Test2"));
            list.add(new User("Test3"));
            list.add(new User("Test4"));

            RouterRequest request = RouterRequest.getBuilder(RouterActivity.this)
                    .provider("TestProvider")
                    .action("TestAction1")
                    .data(list)
                    .CallBack(new ConnectionCallback() {
                        @Override
                        protected void onCallback(Object flag, Object... respData) {
                            Toast.makeText(RouterActivity.this, respData[0].toString(), Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void Error(String e) {

                        }

                        @Override
                        public void onComplete() {

                        }
                    }).build();

            //提供方会在建立Action时提供此Action是否时线程同步，供调用方调用时逻辑判断
            if (request.getAction().isAsync()) {
                request.excute();
            } else {
                //异步操作 data返回也要跟随异步
            }

        } catch (Exception e) {
            Log.i(TAG, "doAction  : " + e.getMessage());
        }
    }



}

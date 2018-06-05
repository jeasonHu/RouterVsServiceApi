package com.hc.routervsserviceapi;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.hc.baseconnection.Test.User;
import com.hc.baseconnection.callback.ConnectionCallback;
import com.hc.baseconnection.router.Request.RouterRequest;
import com.hc.baseconnection.servicesLoader.MyServicesLoader;
import com.hc.baseconnection.servicesLoader.ServicesActionImpl;
import com.hc.routera.RouterActivity;
import com.hc.servicesloada.ServicesAactivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final List<User> list = new ArrayList<User>();
        list.add(new User("Test1"));
        list.add(new User("Test2"));
        list.add(new User("Test3"));
        list.add(new User("Test4"));

        findViewById(R.id.btn_router).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    RouterRequest request = RouterRequest.getBuilder(MainActivity.this)
                            .provider("TestProvider")
                            .action("TestAction")
                            .data(MainActivity.this)
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


        findViewById(R.id.btn_router_callback).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    RouterRequest request = RouterRequest.getBuilder(MainActivity.this)
                            .provider("TestProvider")
                            .action("TestAction1")
                            .data(list)
                            .CallBack(new ConnectionCallback() {
                                @Override
                                protected void onCallback(Object flag, Object... respData) {
                                    Toast.makeText(MainActivity.this, respData[0].toString(), Toast.LENGTH_SHORT).show();
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
        });


        findViewById(R.id.btn_spi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MyServicesLoader.doAction(MainActivity.this,ServicesActionImpl.class,"TestServicesLoader2",null);
            }
        });


        findViewById(R.id.btn_spi_callback).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MyServicesLoader.doAction(MainActivity.this, ServicesActionImpl.class, "TestServicesLoader", new ConnectionCallback() {
                    @Override
                    protected void onCallback(Object flag, Object... respData) {
                        Toast.makeText(MainActivity.this, respData[0].toString(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void Error(String e) {
                        Toast.makeText(MainActivity.this, e, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onComplete() {
                        Toast.makeText(MainActivity.this, "onComplete", Toast.LENGTH_SHORT).show();
                    }
                },list);
            }
        });
    }
}

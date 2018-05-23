package com.hc.routera;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.hc.baseconnection.router.Request.RouterRequest;
import com.hc.baseconnection.router.RouterName;
import com.hc.baseconnection.router.callback.RouterCallback;

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
                    RouterRequest request = RouterRequest.getBuilder()
                            .provider(RouterName.Provider_Test)
                            .action(RouterName.Action_Test)
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

            }
        });
    }


    private void doAction1() {
        try {
            RouterRequest request = RouterRequest.getBuilder()
                    .provider(RouterName.Provider_Test)
                    .action(RouterName.Action_Test1)
                    .CallBack(new RouterCallback() {
                        @Override
                        protected void onCallback(String flag, Object... respData) {

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

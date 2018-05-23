package com.hc.baseconnection;

import com.hc.baseconnection.router.callback.RouterCallback;

public class test extends RouterCallback {


    @Override
    protected void onCallback(String flag, Object... respData) {

    }

    @Override
    public void Error(String e) {

    }

    @Override
    public void onComplete() {


    }


    private void test(){
        RouterCallback callback = new RouterCallback() {
            @Override
            protected void onCallback(String flag, Object... respData) {

            }

            @Override
            public void Error(String e) {

            }

            @Override
            public void onComplete() {

            }
        };
    }


}

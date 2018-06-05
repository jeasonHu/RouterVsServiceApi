package com.hc.routerb;



import android.content.Context;

import com.hc.baseconnection.Test.User;
import com.hc.baseconnection.callback.ConnectionCallback;
import com.hc.baseconnection.router.BaseActionCallback;

import java.util.List;


public class TestAction1 extends BaseActionCallback {


    @Override
    public String getActionName() {
        return "TestAction1";
    }

    @Override
    public void invoke(Context context, ConnectionCallback callback, Object... requestData) {
        try {
            //String param = (String) requestData[1];
            //String msg = (String) requestData[1];

            List<User> list = (List<User>) requestData[0];

            if (callback != null) {
                callback.callback(null, "callback by request size" + list.size());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

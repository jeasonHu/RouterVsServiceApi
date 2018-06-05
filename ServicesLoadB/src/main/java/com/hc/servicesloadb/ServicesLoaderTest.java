package com.hc.servicesloadb;

import android.content.Context;

import com.hc.baseconnection.Test.User;
import com.hc.baseconnection.callback.ConnectionCallback;
import com.hc.baseconnection.servicesLoader.ServicesActionImpl;

import java.util.List;

public class ServicesLoaderTest implements ServicesActionImpl {


    @Override
    public String getName() {
        return "TestServicesLoader";
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

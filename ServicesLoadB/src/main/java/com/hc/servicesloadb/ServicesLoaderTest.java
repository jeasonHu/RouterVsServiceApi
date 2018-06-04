package com.hc.servicesloadb;

import android.content.Context;
import android.content.Intent;

import com.hc.baseconnection.Test.User;
import com.hc.baseconnection.router.callback.RouterCallback;
import com.hc.baseconnection.servicesLoader.ActionImpl;

import java.util.List;

public class ServicesLoaderTest implements ActionImpl{


    @Override
    public String getName() {
        return "TestServicesLoader1";
    }

    @Override
    public void invoke(Context context, Object... requestData) {
        context.startActivity(new Intent(context, ServicesBactivity.class));
    }

    @Override
    public void invoke(Context context, RouterCallback callback, Object... requestData) {
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

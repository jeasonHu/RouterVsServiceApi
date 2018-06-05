package com.hc.servicesloadb;

import android.content.Context;
import android.content.Intent;

import com.hc.baseconnection.callback.ConnectionCallback;
import com.hc.baseconnection.servicesLoader.ServicesActionImpl;


public class ServicesLoaderTest2 implements ServicesActionImpl {


    @Override
    public String getName() {
        return "TestServicesLoader2";
    }


    @Override
    public void invoke(Context context, ConnectionCallback callback, Object... requestData) {
        try {
            context.startActivity(new Intent(context, ServicesBactivity.class));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

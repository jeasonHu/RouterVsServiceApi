package com.hc.baseconnection.servicesLoader;

import android.content.Context;

import com.hc.baseconnection.callback.ConnectionCallback;


public interface ServicesActionImpl {

    String getName();

    void invoke(Context context, ConnectionCallback callback, Object... requestData);
}


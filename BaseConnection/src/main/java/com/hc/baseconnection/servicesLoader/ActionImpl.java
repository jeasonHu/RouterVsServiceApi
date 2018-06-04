package com.hc.baseconnection.servicesLoader;

import android.content.Context;

import com.hc.baseconnection.router.callback.RouterCallback;

public interface ActionImpl {

    String getName();

    void invoke(Context context, Object... requestData);

    void invoke(Context context, RouterCallback callback, Object... requestData);
}


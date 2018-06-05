package com.hc.baseconnection.callback;


public abstract class ConnectionCallbackImpl {

    protected abstract void onCallback(Object flag, Object... respData);

    public abstract void Error(String e);

    public abstract void onComplete();
}

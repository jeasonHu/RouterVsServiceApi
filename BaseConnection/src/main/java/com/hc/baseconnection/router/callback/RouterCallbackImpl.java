package com.hc.baseconnection.router.callback;

public abstract class RouterCallbackImpl {

    protected abstract void onCallback(String flag, Object... respData);

    public abstract void Error(String e);

    public abstract void onComplete();
}

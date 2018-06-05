package com.hc.baseconnection.callback;


/**
 * 业务调用回掉类
 *
 * @param
 * @date 2017/4/19 下午2:38
 * @return
 */
public abstract class ConnectionCallback extends ConnectionCallbackImpl {


    public void callback(Object flag, Object... respData) {
        onCallback(flag,respData);
        onComplete();
    }
}

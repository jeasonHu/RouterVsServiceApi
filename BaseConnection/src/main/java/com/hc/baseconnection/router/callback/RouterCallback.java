package com.hc.baseconnection.router.callback;


/**
 * 业务调用回掉类
 *
 * @param
 * @date 2017/4/19 下午2:38
 * @return
 */
public abstract class RouterCallback extends RouterCallbackImpl {


    public void callback(String flag, Object... respData) {
        onCallback(flag,respData);
        onComplete();
    }
}

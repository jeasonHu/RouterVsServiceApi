package com.hc.baseconnection.router;


import com.hc.baseconnection.router.callback.RouterCallback;

/**
 * 提供方提供 action 类
 *
 * @date 2017/4/21 上午10:31
 */

public abstract class BaseActionCallback extends BaseAction {

    @Override
    public void invoke(Object... requestData) {
        invoke(null, requestData);
    }

    public abstract void invoke(RouterCallback callback, Object... requestData);
}

package com.hc.baseconnection.router;


import android.content.Context;

import com.hc.baseconnection.router.callback.RouterCallback;


/**
 * 提供方提供 action 类
 *
 * @date 2017/4/21 上午10:31
 */

public abstract class BaseActionCallback extends BaseAction {

    protected String CallBack_DefaultFlag = "0";

    @Override
    public void invoke(Context context, Object... requestData) {
        invoke(context,null, requestData);
    }

    public abstract void invoke(Context context, RouterCallback callback, Object... requestData);
}

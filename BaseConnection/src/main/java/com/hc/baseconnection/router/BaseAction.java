package com.hc.baseconnection.router;


import android.content.Context;

/**
 * 提供方提供 action 类
 *
 * @date 2017/4/21 上午10:31
 */

public abstract class BaseAction {

    /**
     * 标示执行回调的线程是否与调用线程同步
     * 默认 同步
     *
     * @param
     * @return
     * @date 2017/11/24 下午2:15
     */
    public boolean isAsync() {
        return true;
    }



    public String getActionName(){
        return null;
    }

    /**
     * 标示函数是否是耗时操作
     * 默认不需要耗时操作
     *
     * @param
     * @return
     * @date 2017/11/24 下午2:16
     */
    public boolean TimeConsuming() {
        return false;
    }


    public abstract void invoke(Context context, Object... requestData);
}

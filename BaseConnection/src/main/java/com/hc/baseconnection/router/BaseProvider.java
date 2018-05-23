package com.hc.baseconnection.router;

import java.util.HashMap;

/**
 * 接口提供方基类
 * @date 2017/4/20 下午6:19
 * @param
 * @return
 */
public class BaseProvider {

    private HashMap<String, BaseAction> actions = null;

    public HashMap<String, BaseAction> getActions() {
        if (actions == null) {
            actions = new HashMap<String, BaseAction>();
        }
        return actions;
    }


    public BaseProvider() {
        registerActions();
    }

    /**
     * 初始化注册action  默认空构造函数调用  子类有重构构造函数需调用 本函数
     * @date 2017/4/20 下午6:20
     * @param
     * @return
     */
    public void registerActions() {

    }


    /**
     * 注册action
     * @date 2017/4/20 下午6:21
     * @param
     * @return
     */
    public void registerAction(String key, BaseAction action) {
        getActions().put(key, action);
    }
}

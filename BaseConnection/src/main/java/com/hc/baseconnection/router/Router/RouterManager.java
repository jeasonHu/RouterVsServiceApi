package com.hc.baseconnection.router.Router;


import com.hc.baseconnection.router.BaseProvider;

import java.util.HashMap;

/**
 * 组件通信管理
 *
 * @author statham
 * @date 2017/4/19 下午2:32
 */

public class RouterManager {

    private static RouterManager instance = new RouterManager();

    public static RouterManager getInstance() {
        if (instance == null) {
            instance = new RouterManager();
        }
        return instance;
    }

    private HashMap<String, BaseProvider> providers = null;

    public HashMap<String, BaseProvider> getProviders() {
        /*if (providers == null) {
            providers = new HashMap<String, BaseProvider>();
        }*/
        return providers;
    }

    /**
     * @param
     * @return
     * @autuor statham
     * @date 2017/4/20 下午6:09
     */
    public void addProvider(HashMap<String, BaseProvider> providers) {
        this.providers = providers;
    }


}

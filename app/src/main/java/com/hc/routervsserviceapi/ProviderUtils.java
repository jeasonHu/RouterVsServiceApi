package com.hc.routervsserviceapi;


import com.hc.baseconnection.router.BaseProvider;
import com.hc.baseconnection.router.Router.RouterManager;
import com.hc.baseconnection.router.RouterName;
import com.hc.routerb.TestProvider;

import java.util.HashMap;

public class ProviderUtils {


    private static final ProviderUtils ourInstance = new ProviderUtils();

    public static ProviderUtils getInstance() {
        return ourInstance;
    }

    private ProviderUtils() {

    }

    private HashMap<String, BaseProvider> providers = null;

    public void bindProvider() {
        providers = new HashMap<String, BaseProvider>();
        providers.put(RouterName.Provider_Test, new TestProvider());

        RouterManager.getInstance().addProvider(providers);
    }


    public void checkProviders() {
        try {
            if (RouterManager.getInstance().getProviders() == null
                    || RouterManager.getInstance().getProviders().size() <= 0) {
                bindProvider();
            }
        } catch (Exception e) {

        }
    }
}

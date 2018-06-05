package com.hc.baseconnection.servicesLoader;


import android.content.Context;

import com.hc.baseconnection.callback.ConnectionCallback;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;

public class MyServicesLoader {

    private static Map<String, Object> providerServices = new HashMap<String, Object>();

    private static Map<String, Object> getProviderServices() {
        if (providerServices == null) {
            providerServices = new HashMap<String, Object>();
        }
        return providerServices;
    }


    public static ServicesActionImpl getService(Class tClass, String servicesName) {
        String mapKey = tClass.getSimpleName() + "_" + servicesName;

        ServicesActionImpl object = (ServicesActionImpl) getProviderServices().get(mapKey);
        if (object != null) {
            return object;
        } else {
            ServiceLoader<ServicesActionImpl> loader = ServiceLoader.load(tClass);
            Iterator<ServicesActionImpl> mIterator = loader.iterator();
            ServicesActionImpl services = null;
            while (mIterator.hasNext()) {
                services = mIterator.next();
                mapKey = tClass.getSimpleName() + "_" + services.getName();
                if (services.getName().equals(servicesName)) {
                    object = services;
                }
                getProviderServices().put(mapKey, services);
            }
        }
        return object;
    }


    public static void doAction(Context context, Class tClass, String servicesName, ConnectionCallback callback, Object... requestData) {
        ServicesActionImpl action = MyServicesLoader.getService(ServicesActionImpl.class, servicesName);
        if (action != null) {
            action.invoke(context, callback, requestData);
        } else {
            if (callback != null) {
                callback.callback(null,"Cannot find the services name by :" + servicesName);
            }
        }
    }
}

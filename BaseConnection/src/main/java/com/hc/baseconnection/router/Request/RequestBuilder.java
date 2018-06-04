package com.hc.baseconnection.router.Request;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.hc.baseconnection.router.BaseAction;
import com.hc.baseconnection.router.BaseProvider;
import com.hc.baseconnection.router.Router.RouterManager;
import com.hc.baseconnection.router.callback.RouterCallback;


public class RequestBuilder implements RequestBuilderimpl {

    private String providerKey;
    private String actionkey;

    private RouterCallback callback;
    private Object[] requestData;
    private BaseAction action;


    private Context context;

    public RequestBuilder() {
    }

    public RequestBuilder(Context context) {
        this.context = context;
    }

    public RouterCallback getCallback() {
        return callback;
    }


    public Object[] getRequestData() {
        return requestData;
    }

    @Override
    public RequestBuilder provider(@NonNull String key) {
        providerKey = key;
        return this;
    }

    @Override
    public RequestBuilder action(@NonNull String key) {
        actionkey = key;
        return this;
    }

    @Override
    public RequestBuilder data(Object... requestdata) {
        if(requestdata != null){
            this.requestData = requestdata;
        }
        return this;
    }

    @Override
    public RequestBuilder CallBack(RouterCallback callback) {
        this.callback = callback;
        return this;
    }

    @Override
    public RouterRequest build() throws Exception {
        try {
            action = getAction();
            if (action != null) {
                return new RouterRequest(context,action,this);
            } else {
                throw new Exception("action is not be found!");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    private BaseAction getAction() throws Exception {
        action = null;
        try {
            BaseProvider provider;
            if (TextUtils.isEmpty(providerKey)) {
                throw new Exception("provider key is null!");
            }
            if (RouterManager.getInstance().getProviders() != null
                    && RouterManager.getInstance().getProviders().size() > 0) {
                provider = RouterManager.getInstance().getProviders().get(providerKey);
                if (provider != null) {
                    if (provider.getActions() != null && provider.getActions().size() > 0) {
                        action = provider.getActions().get(actionkey);
                    } else {
                        throw new Exception("Actions Hash is null!");
                    }
                } else {
                    throw new Exception("provider is not be found");
                }

            } else {
                throw new Exception("RouterProviders Hash is null!");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return action;
    }


}
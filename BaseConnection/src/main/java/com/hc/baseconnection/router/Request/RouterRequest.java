package com.hc.baseconnection.router.Request;


import android.content.Context;

import com.hc.baseconnection.router.BaseAction;
import com.hc.baseconnection.router.BaseActionCallback;
import com.hc.baseconnection.router.callback.RouterCallback;


public class RouterRequest implements RequestImpl {

    private BaseAction action;
    private RequestBuilder builder;
    private Context context;


    public RouterRequest(Context context, BaseAction action, RequestBuilder builder) {
        this.context = context;
        this.action = action;
        this.builder = builder;
    }

    /*public static RequestBuilder getBuilder() {
        return new RequestBuilder();
    }*/

    public static RequestBuilder getBuilder(Context context) {
        return new RequestBuilder(context);
    }

    @Override
    public BaseAction getAction() {
        return action;
    }

    @Override
    public void excute() throws Exception {
        try {
            if (action != null && builder != null) {
                if(action instanceof BaseActionCallback){
                    if(builder.getCallback() == null){
                        ((BaseActionCallback)action).invoke(context,new RouterCallback() {
                            @Override
                            protected void onCallback(String flag, Object... respData) {

                            }

                            @Override
                            public void Error(String e) {

                            }

                            @Override
                            public void onComplete() {

                            }
                        }, builder.getRequestData());
                    } else {
                        ((BaseActionCallback)action).invoke(context,builder.getCallback(), builder.getRequestData());
                    }
                } else {
                    action.invoke(context,builder.getRequestData());
                }

                /*if (builder.getRequestData() != null) {
                    action.invoke(builder.getCallback(), builder.getRequestData());
                } else {
                    if (builder.getCallback() == null) {
                        action.invoke();
                    } else {
                        action.invoke(builder.getCallback());
                    }
                }*/
            } else {
                throw new Exception("action has not be found!");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}

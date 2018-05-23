package com.hc.baseconnection.router.Request;

import com.hc.baseconnection.router.BaseAction;
import com.hc.baseconnection.router.BaseActionCallback;


public class RouterRequest implements RequestImpl {


    private BaseAction action;
    private RequestBuilder builder;


    public RouterRequest(BaseAction action, RequestBuilder builder) {
        this.action = action;
        this.builder = builder;
    }

    public static RequestBuilder getBuilder() {
        return new RequestBuilder();
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
                    action.invoke(builder.getCallback(), builder.getRequestData());
                } else {
                    action.invoke(builder.getRequestData());
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

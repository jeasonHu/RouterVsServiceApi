package com.hc.routerb;

import android.content.Context;
import android.content.Intent;

import com.hc.baseconnection.router.BaseAction;

public class TestAction extends BaseAction {

    @Override
    public boolean isAsync() {
        return super.isAsync();
    }

    @Override
    public boolean TimeConsuming() {
        return super.TimeConsuming();
    }




    @Override
    public String getActionName() {
        return "TestAction";
    }

    @Override
    public void invoke(Context context, Object... requestData) {
        context.startActivity(new Intent(context, RouterBactivity.class));
    }
}

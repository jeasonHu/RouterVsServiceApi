package com.hc.routerb;

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
    public void invoke(Object... requestData) {

    }
}

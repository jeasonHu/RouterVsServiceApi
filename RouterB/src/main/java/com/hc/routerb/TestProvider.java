package com.hc.routerb;

import com.hc.baseconnection.router.BaseAction;
import com.hc.baseconnection.router.BaseProvider;
import com.hc.baseconnection.router.RouterName;

public class TestProvider extends BaseProvider {


    public TestProvider() {
    }


    @Override
    public String getProviderName() {
        return "TestProvider";
    }

    @Override
    public void registerActions() {
        super.registerActions();

        BaseAction testAction = new TestAction();
        registerAction(testAction.getActionName(),testAction);
        testAction = new TestAction1();
        registerAction(testAction.getActionName(),testAction);
    }
}

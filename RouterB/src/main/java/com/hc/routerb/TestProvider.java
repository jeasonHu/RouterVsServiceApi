package com.hc.routerb;

import com.hc.baseconnection.router.BaseProvider;
import com.hc.baseconnection.router.RouterName;

public class TestProvider extends BaseProvider {

    public static final String Provider_Api = "TestProvider";

    public TestProvider() {
    }

    @Override
    public void registerActions() {
        super.registerActions();

        registerAction(RouterName.Action_Test,new TestAction());
        registerAction(RouterName.Action_Test1,new TestAction1());
    }
}

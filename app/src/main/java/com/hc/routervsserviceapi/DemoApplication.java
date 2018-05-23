package com.hc.routervsserviceapi;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

public class DemoApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        //Logger.setDebug一定要在最先执行

        ProviderUtils.getInstance().bindProvider();


        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle bundle) {

            }


            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {
                ProviderUtils.getInstance().checkProviders();
            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {

            }
        });
    }

}
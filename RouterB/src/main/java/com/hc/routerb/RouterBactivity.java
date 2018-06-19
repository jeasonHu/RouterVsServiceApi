package com.hc.routerb;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.hc.routerb.My_RouterBactivityAutoGenerate;
import com.hyx.sdyx.apt.annotation.Action;

public class RouterBactivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routerb);
        test();
    }

    @Action("hehe")
    private void test(){
        My_RouterBactivityAutoGenerate.printTest();
    }
}

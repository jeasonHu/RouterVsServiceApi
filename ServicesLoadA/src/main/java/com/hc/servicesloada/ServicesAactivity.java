package com.hc.servicesloada;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.hc.baseconnection.Test.User;
import com.hc.baseconnection.router.callback.RouterCallback;
import com.hc.baseconnection.servicesLoader.ActionImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;


public class ServicesAactivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicesa);

        findViewById(R.id.btn_action).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadSpi();
            }
        });


        findViewById(R.id.btn_action_callback).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadSpi2();
            }
        });
    }

    private void loadSpi(){
        ServiceLoader<ActionImpl> loader = ServiceLoader.load(ActionImpl.class);
        Iterator<ActionImpl> mIterator = loader.iterator();
        ActionImpl action = null;
        while (mIterator.hasNext()){
            action = mIterator.next();
            if(action.getName().equals("TestServicesLoader1")){
                action.invoke(ServicesAactivity.this);
            }
        }

    }

    private void loadSpi2(){
        ServiceLoader<ActionImpl> loader = ServiceLoader.load(ActionImpl.class);
        Iterator<ActionImpl> mIterator = loader.iterator();
        ActionImpl action = null;
        while (mIterator.hasNext()){
            action = mIterator.next();
            if(action.getName().equals("TestServicesLoader1")){

                List<User> list = new ArrayList<User>();
                list.add(new User("Test1"));
                list.add(new User("Test2"));
                list.add(new User("Test3"));
                list.add(new User("Test4"));
                action.invoke(ServicesAactivity.this,new RouterCallback() {
                    @Override
                    protected void onCallback(String flag, Object... respData) {
                        Toast.makeText(ServicesAactivity.this, respData[0].toString(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void Error(String e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                }, list);
            }
        }
    }
}

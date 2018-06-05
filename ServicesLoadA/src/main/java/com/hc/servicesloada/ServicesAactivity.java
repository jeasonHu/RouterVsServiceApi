package com.hc.servicesloada;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.hc.baseconnection.Test.User;
import com.hc.baseconnection.callback.ConnectionCallback;
import com.hc.baseconnection.servicesLoader.MyServicesLoader;
import com.hc.baseconnection.servicesLoader.ServicesActionImpl;

import java.util.ArrayList;
import java.util.List;


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
        MyServicesLoader.doAction(ServicesAactivity.this,ServicesActionImpl.class,"TestServicesLoader2",null);
    }

    private void loadSpi2(){
        List<User> list = new ArrayList<User>();
        list.add(new User("Test1"));
        list.add(new User("Test2"));
        list.add(new User("Test3"));
        list.add(new User("Test4"));


        MyServicesLoader.doAction(ServicesAactivity.this, ServicesActionImpl.class, "TestServicesLoader", new ConnectionCallback() {
            @Override
            protected void onCallback(Object flag, Object... respData) {
                Toast.makeText(ServicesAactivity.this, respData[0].toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void Error(String e) {
                Toast.makeText(ServicesAactivity.this, e, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onComplete() {
                Toast.makeText(ServicesAactivity.this, "onComplete", Toast.LENGTH_SHORT).show();
            }
        },list);

        /*ServiceLoader<ServicesActionImpl> loader = ServiceLoader.load(ServicesActionImpl.class);
        Iterator<ServicesActionImpl> mIterator = loader.iterator();
        ServicesActionImpl action = null;
        while (mIterator.hasNext()){
            action = mIterator.next();
            if(action.getName().equals("TestServicesLoader")){


                action.invoke(ServicesAactivity.this,new ConnectionCallback() {
                    @Override
                    protected void onCallback(Object flag, Object... respData) {
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
        }*/
    }
}

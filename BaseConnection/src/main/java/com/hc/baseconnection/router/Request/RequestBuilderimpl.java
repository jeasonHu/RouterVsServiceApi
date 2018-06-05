package com.hc.baseconnection.router.Request;


import com.hc.baseconnection.callback.ConnectionCallback;

public interface RequestBuilderimpl {


    RequestBuilderimpl provider(String key);//设置providerkey

    RequestBuilderimpl action(String key);//设置actionkey

    RequestBuilderimpl data(Object[] requestdata);//设置请求参数  key-value

    RequestBuilderimpl CallBack(ConnectionCallback callback);//设置回调

    RouterRequest build() throws Exception;//构建Request


}

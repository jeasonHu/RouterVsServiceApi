package com.hc.baseconnection.router.Request;


import com.hc.baseconnection.router.BaseAction;

public interface RequestImpl {

    void excute() throws Exception;//执行request

    BaseAction getAction();// 获取请求Action
}

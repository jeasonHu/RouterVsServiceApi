package com.hyx.sdyx.apt;

import com.hyx.sdyx.apt.annotation.Action;

public class TestMain {

    public static void main(String[] args) {
        test();
        System.out.println("xxx");
    }

    @Action("xxx")
    private static void test(){

    }


}

package com.example.myapplication.model;

public class MainResponse {
    public com.example.myapplication.model.MobileInitialize getMobileInitialize() {
        return MobileInitialize;
    }

    public void setMobileInitialize(com.example.myapplication.model.MobileInitialize mobileInitialize) {
        MobileInitialize = mobileInitialize;
    }

    private static  MainResponse mainResponse;
    private MobileInitialize MobileInitialize;

    public static MainResponse getInstance() {
        if(mainResponse == null) {
            mainResponse = new MainResponse();
        }
        return mainResponse;
    }
    public static void setResponse(MainResponse response) {
        mainResponse = response;
    }
}

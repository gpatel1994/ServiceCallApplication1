package com.example.myapplication.model;

import java.util.ArrayList;
import java.util.List;

public class MobileInitialize {

    private static MobileInitialize mobileInitialize;
    private FeatureSplash featureSplash;
    private StartUpConfig startUpConfig;
    private InAuth inAuth;
    private MobileContentVersion mobileContentVersion;
    private Eula eula;
    private InAuthV2 inAuthV2;

    public static MobileInitialize getInstance() {
        if(mobileInitialize == null) {
            mobileInitialize = new MobileInitialize();
        }
        return mobileInitialize;

    }

    public static void clearInstance(){
        mobileInitialize = null;
    }

    public FeatureSplash getFeatureSplash() {
        return featureSplash;
    }

    public void setFeatureSplash(FeatureSplash featureSplash) {
        this.featureSplash = featureSplash;
    }

    public StartUpConfig getStartUpConfig() {
        return startUpConfig;
    }

    public void setStartUpConfig(StartUpConfig startUpConfig) {
        this.startUpConfig = startUpConfig;
    }

    public InAuth getInAuth() {
        return inAuth;
    }

    public void setInAuth(InAuth inAuth) {
        this.inAuth = inAuth;
    }

    public MobileContentVersion getMobileContentVersion() {
        return mobileContentVersion;
    }

    public void setMobileContentVersion(MobileContentVersion mobileContentVersion) {
        this.mobileContentVersion = mobileContentVersion;
    }

    public Eula getEula() {
        return eula;
    }

    public void setEula(Eula eula) {
        this.eula = eula;
    }

    public InAuthV2 getInAuthV2() {
        return inAuthV2;
    }

    public void setInAuthV2(InAuthV2 inAuthV2) {
        this.inAuthV2 = inAuthV2;
    }

    @Override
    public String toString() {
        return "MobileInitialize{" +
                "featureSplash=" + featureSplash +
                ", startUpConfig=" + startUpConfig +
                ", inAuth=" + inAuth +
                ", mobileContentVersion=" + mobileContentVersion +
                ", eula=" + eula +
                ", inAuthV2=" + inAuthV2 +
                '}';
    }

    public static void setResponse(MobileInitialize fromJson) {
        MobileInitialize.mobileInitialize = fromJson;
    }
}

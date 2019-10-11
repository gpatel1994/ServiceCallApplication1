package com.example.myapplication.model;

public class FeatureSplash {
    public DegradedRemoveLink getDegradedRemoveLink() {
        return degradedRemoveLink;
    }

    public void setDegradedRemoveLink(DegradedRemoveLink degradedRemoveLink) {
        this.degradedRemoveLink = degradedRemoveLink;
    }


    private DegradedRemoveLink degradedRemoveLink;

    @Override
    public String toString() {
        return "FeatureSplash{" +
                "degradedRemoveLink=" + degradedRemoveLink +
                '}';
    }

}

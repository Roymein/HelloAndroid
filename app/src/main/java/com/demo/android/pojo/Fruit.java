package com.demo.android.pojo;

public class Fruit {

    private String mName;
    private int mImageId;

    public Fruit(String name, int imageId) {
        mName = name;
        mImageId = imageId;
    }

    public String getName() {
        return mName;
    }

    public int getImageId() {
        return mImageId;
    }
}

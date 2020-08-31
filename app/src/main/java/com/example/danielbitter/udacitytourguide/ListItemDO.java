package com.example.danielbitter.udacitytourguide;

import android.content.Context;

/**
 * Created by danielbitter on 12/13/16.
 */

public class ListItemDO {

    private Context context;
    private int imageId;
    private int HAS_IMAGE=0;
    private String title;
    private String address;
    private String webAddress;
    private double latitude;
    private double longitude;

    public ListItemDO(String s, Context context){
        this.context = context;
        this.title = s;
    }

    public ListItemDO(int imgId, String ttl){
        this.imageId = imgId;
        this.title = ttl;
    }

    public void setImageId(int imgId){
        this.HAS_IMAGE = 1;
        this.imageId = imgId;}
    public void setTitle(String ttl){this.title = ttl;}
    public void setAddress(String addr){
        addr = addr.replaceAll(context.getString(R.string.constant_space),
                context.getString(R.string.constant_space));
        this.address=addr;}
    public void setWebAddress(String webAddr){this.webAddress = webAddr;}
    public void setLatitude(double lat){this.latitude = lat;}
    public void setLongitude(double lon){this.longitude = lon;}

    public int getImageId(){return this.imageId;}
    public boolean getHasImage(){return this.HAS_IMAGE > 0;}
    public String getTitle(){
        return this.title;
    }
    public String getAddress(){return this.address;}
    public String getWebAddress(){return this.webAddress;}
    public double getLatitude(){return this.latitude;}
    public double getLongitude(){return this.longitude;}
}

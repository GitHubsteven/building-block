package com.variety.shop.indi.webpattern;

import java.io.Serializable;
import java.util.List;

/**
 * Created by rongbin.xie on 2017/9/8.
 */
public abstract class IRequest<T> implements Serializable {
    private List<T> data;
    //请求起始地
    private String startPlace;
    //目的地
    private String destination;



    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public String getStartPlace() {
        return startPlace;
    }

    public void setStartPlace(String startPlace) {
        this.startPlace = startPlace;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}

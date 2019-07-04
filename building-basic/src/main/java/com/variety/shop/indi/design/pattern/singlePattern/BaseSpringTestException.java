package com.variety.shop.indi.design.pattern.singlePattern;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rongbin.xie on 2017/10/26.
 */
public class BaseSpringTestException {
    private String responseCode;

    //懒汉模式
    private static BaseSpringTestException singleton = null;

    private BaseSpringTestException() {
        super();
    }

    public synchronized static BaseSpringTestException newInstance() {
       if(null == singleton){
           singleton =new BaseSpringTestException();
       }
       return singleton;
    }

    private Map<String, String> exceptionTranMap = new HashMap<>();

    {
        exceptionTranMap.put("A", "exception A");
        exceptionTranMap.put("B", "exception B");
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String transferException() {
        return exceptionTranMap.get(this.getResponseCode());
    }

}

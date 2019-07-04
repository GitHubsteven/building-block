package com.variety.shop.indi.webpattern;

/**
 * Created by rongbin.xie on 2017/9/8.
 */
public interface IClient {
    void sendRequest(IRequest request);

    void sendRequest(IRequest request, Long delaySecond);
}

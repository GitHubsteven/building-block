package com.variety.shop.indi.webpattern;

import java.io.Serializable;
import java.util.List;

/**
 *server IResponse 类
 *
 * @author rongbin.xie on 2017/9/8.
 */
public abstract  class IResponse<T> implements Serializable {
    abstract List<T> answer();
}

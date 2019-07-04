package com.variety.shop.indi.inter;

/**
 * Created by rongbin.xie on 2017/9/5.
 */
public interface FuncInterTest1 {
    default Integer getData(){
        return 10;
    }

    Integer getMul(int x);

    Integer getNext(int x);
}

package com.variety.shop.indi.generic;

import java.util.List;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author rongbin.xie
 * @Description:
 * @Date: Created at 14:28 2018/4/27.
 */
public interface IAsaOperator<T> {

    List<T>  listItems();

    void  OperateItem(T t);

    void introduce();
}

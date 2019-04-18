package com.asa.x.jxls;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 14:23 2019/4/17.
 */
@Setter
@Getter
public class RequestBean implements Serializable {
    private String clzName;

    List<ItemBean> items = new ArrayList<>();
}
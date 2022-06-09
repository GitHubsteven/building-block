package com.demo.asa.building.proxy.bean;

import com.demo.asa.building.IEnableMC;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.util.StringUtils;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2022/6/8
 * @description
 * @copyright COPYRIGHT © 2014 - 2021/5/18 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Setter
@Getter
@ToString
public class QueryBean implements IEnableMC {
    private String no;

    @Override
    public boolean enableMc() {
        return !StringUtils.isEmpty(no) && no.contains("mc");
    }
}

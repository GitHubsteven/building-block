package com.demo.asa.building.reflect.type;

import java.io.Serializable;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 17:41 2019/10/16.
 */
public class TypeModel extends BaseModel<Integer> implements IModel<String>, Serializable {
    @Override
    public void buildModel() {

    }

    @Override
    public String where() {
        return null;
    }

    @Override
    public String from() {
        return null;
    }
}
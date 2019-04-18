package com.asa.x.jxls;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 14:52 2019/4/18.
 */
@Setter
@Getter
@Accessors(chain = true)
public class FieldInfo {
    private String name;
    private String type;
    private String comment;

    public FieldInfo(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public FieldInfo(String name, String type, String comment) {
        this.name = name;
        this.type = type;
        this.comment = comment;
    }
}
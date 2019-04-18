package com.asa.x.jxls;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 14:24 2019/4/17.
 */
@Setter
@Getter
public class ItemBean implements Serializable {
    private String fieldPath;
    private String fieldName;
    private String constraint;
    private String description;
}
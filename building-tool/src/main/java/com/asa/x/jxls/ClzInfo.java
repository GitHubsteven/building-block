package com.asa.x.jxls;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 14:13 2019/4/18.
 */
@Setter
@Getter
public class ClzInfo {
    private String name;
    private List<FieldInfo> fields; //left -> type, right->name
}
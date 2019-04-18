package com.asa.x.jxls;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 15:15 2019/4/18.
 */
@Setter
@Getter
public class ItemNode {
    private String path;
    private ItemBean cur;
    private List<ItemNode> subNodes = new ArrayList<>(0);
}
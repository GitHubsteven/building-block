package com.asa.x.jxls;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 14:22 2019/4/18.
 */
@Setter
@Getter
public class TreeNode {
    private String name;
    private String type;
    private List<TreeNode> subFields;

    public TreeNode(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public TreeNode() {
    }
}
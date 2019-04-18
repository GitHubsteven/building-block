package com.asa.x.jxls.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 18:26 2019/4/18.
 */
@Setter
@Getter
public class ParentModel {
    private String name;

    public static void main(String[] args) {
        System.out.println(ParentModel.class.getSuperclass().getSuperclass() != null);
    }
}
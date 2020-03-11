package com.demo.asa.building.reflect.type;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author asa.x
 * @Date: Created at 19:24 2020/3/10.
 */
@Setter
@Getter
@ToString
public class GetOrderResponse implements Serializable {
    private String name;
    private Integer age;
}
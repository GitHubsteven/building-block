package com.demo.asa.building.reflect.annotation;

import lombok.Getter;
import lombok.Setter;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 10:37 2019/11/13.
 */
@VOMQQueue("test-mq")
@Setter
@Getter
public class MqMessageBody {
    private Boolean isKof = false;
}
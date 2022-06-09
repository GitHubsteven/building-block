package com.demo.asa.building.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2022/6/9
 * @description
 * @copyright COPYRIGHT © 2014 - 2021/5/18 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Service
public class AcService {
    @Autowired
    @Qualifier("ActionServiceProxy")
    private IActionService iActionService;

}

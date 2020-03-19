package pers.demo.build.converter.jackson.xml.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @version 1.0.0
 * @author: rongbin.xie
 * @date: 2020/3/18
 * @CopyRight: COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Setter
@Getter
public class XstreamBean {
    private String name;
    private String location;
    private List<String> friends;
    private Integer age;
}

package pers.demo.build.converter.jackson.xml.bean;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.Setter;
import pers.demo.build.converter.jackson.xml.XmlUtils;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * @version 1.0.0
 * @author: rongbin.xie
 * @date: 2020/3/18
 * @CopyRight: COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Setter
@Getter
@JacksonXmlRootElement(localName = "friends")
public class XmlBean implements Serializable {
    private String name;
    private String location;
    @JacksonXmlProperty(localName = "friend")
    private List<String> friends;
    private Integer age;

    public static void main(String[] args) {
        XmlBean xmlBean = new XmlBean();
        xmlBean.setName("xmlBean");
        xmlBean.setLocation("SH");
        xmlBean.setFriends(Collections.singletonList("Jackson"));
        String xml = XmlUtils.toXml(xmlBean);
        System.out.println(xml);


        XmlBean fromXmlBean = (XmlBean) XmlUtils.fromXmlViaType(xml, XmlBean.class);
        System.out.println(fromXmlBean.getFriends().size());
    }
}

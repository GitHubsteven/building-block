package jaxb.teach;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * @author: jet.xie
 * @Date: 2018/9/27
 * @Description:
 * @version: 1.0.0
 */
@Setter
@Getter
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class Address {
    private String province;
    private String city;
    private String district;
    private String street;

}
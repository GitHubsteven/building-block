package jaxb.teach;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * @author: jet.xie
 * @Date: 2018/9/27
 * @Description:
 * @version: 1.0.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@Setter
@Getter
public class ShoppingItem {
    private String name;
    private float price;
    private int num;
}
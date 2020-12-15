package jaxb.custom;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.*;

/**
 * @author: jet.xie
 * @Date: 2018/9/27
 * @Description:
 * @version: 1.0.0
 */
@Setter
@Getter
@XmlAccessorType(XmlAccessType.FIELD)
public class BaseBody {
    @XmlElement(name = "id")
    private Long id;
}
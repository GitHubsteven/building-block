package jaxb.test;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.*;

/**
 * @author: jet.xie
 * @Date: 2018/9/27
 * @Description:
 * @version: 1.0.0
 */
@XmlRootElement(name = "Body")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "name",
        "age"
})
@Setter
@Getter
public class Body2 extends BaseBody {
    @XmlElement(name = "name", required = true)
    private String name;
    @XmlElement(name = "age", required = true)
    private Integer age;
}
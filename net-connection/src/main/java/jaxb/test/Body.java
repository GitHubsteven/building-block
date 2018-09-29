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
        "dept"
})
@Setter
@Getter
public class Body extends BaseBody {
    // 简写....
    @XmlElement(name = "name", required = true)
    protected String name;

    @XmlElement(name = "dept", required = true)
    protected String dept;

}

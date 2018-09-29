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
@Setter
@Getter
@XmlRootElement(name = "Document")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "request"
})
public class Document {
    @XmlElements({@XmlElement(name = "request", type = jaxb.test.Request2.class)})
    protected BaseRequest<? extends BaseBody> request;

}
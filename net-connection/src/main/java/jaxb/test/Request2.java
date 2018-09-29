package jaxb.test;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author: jet.xie
 * @Date: 2018/9/27
 * @Description:
 * @version: 1.0.0
 */
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "", propOrder = {"head", "body"})
public class Request2 extends BaseRequest<Body2> {

    @XmlElement(name = "Head", required = true)
    @Override
    public Head getHead() {
        return head;
    }

    @Override
    public void setHead(Head value) {
        this.head = value;
    }

    @XmlElement(name = "Body", required = true)
    @Override
    public Body2 getBody() {
        return body;
    }

    @Override
    public void setBody(Body2 value) {
        this.body = value;
    }
}

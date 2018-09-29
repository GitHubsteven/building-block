package jaxb.test;

import javax.xml.bind.annotation.XmlTransient;

/**
 * @author: jet.xie
 * @Date: 2018/9/27
 * @Description:
 * @version: 1.0.0
 */

@XmlTransient
public abstract class BaseRequest<T extends BaseBody> {

    protected Head head;
    protected T body;

    public abstract Head getHead();
    public abstract void setHead(Head value);
    public abstract T getBody();
    public abstract void setBody(T value);
}

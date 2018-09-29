package xstream.generic.custom.test;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: jet.xie
 * @Date: 2018/9/26
 * @Description:
 * @version: 1.0.0
 */
@Setter
@Getter
@JacksonXmlRootElement(localName = "alipay")
public class Response<T extends RespBase> {
    private String name;
    @JacksonXmlProperty(localName = "data")
    private DataWrapper<T> data;
}
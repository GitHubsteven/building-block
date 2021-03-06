package xstream.generic.custom.test;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
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
public class DataWrapper<R> {
    @JacksonXmlProperty(localName = "alipay")
    private R data;
}
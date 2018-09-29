package jackson.test;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.Setter;
import xstream.generic.custom.test.Custom;

/**
 * @author: jet.xie
 * @Date: 2018/9/26
 * @Description:
 * @version: 1.0.0
 */
@Setter
@Getter
@JacksonXmlRootElement(localName = "alipay")
public class CustomXml {
    private String name;
    @JacksonXmlProperty(localName = "data")
    private CustomWrapper data;

    @Setter
    @Getter
    static class CustomWrapper {
        @JacksonXmlProperty(localName = "alipay")
        private Custom custom;
    }
}
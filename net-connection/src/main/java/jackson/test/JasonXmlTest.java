package jackson.test;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.util.Collection;

/**
 * @author: jet.xie
 * @Date: 2018/9/26
 * @Description:
 * @version: 1.0.0
 */
public class JasonXmlTest {
    private static final XmlMapper xmlMapper = new XmlMapper();


    public static void main(String[] args) {
        String xml = "<root k6=\"6\">\n" +
                "    <k1>str</k1>\n" +
                "    <k-2>2</k-2>\n" +
                "    <k3>\n" +
                "        <ki>1</ki>\n" +
                "        <ki>2</ki>\n" +
                "    </k3>\n" +
                "    <k4>\n" +
                "        <ka>3</ka>\n" +
                "        <ka>4</ka>\n" +
                "    </k4>\n" +
                "    <k5>5-1</k5>\n" +
                "    <k5>5-2</k5>\n" +
                "    <k7>a7b</k7>\n" +
                "    <k8><a>8</a></k8>\n" +
                "    <k9><![CDATA[中<a>文]]></k9>\n" +
                "</root>\n";
        try {
            RootXml root = xmlMapper.readValue(xml, RootXml.class);
            System.out.println(root.k1);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @JacksonXmlRootElement(localName = "root")
    @Setter
    @Getter
    static class RootXml {
        private String k1;
        @JacksonXmlProperty(localName = "k-2")
        private Integer k2;
        @JacksonXmlElementWrapper(localName = "k3")
        @JacksonXmlProperty(localName = "ki")
        private Collection<String> k3;
        @JacksonXmlElementWrapper(localName = "k4")
        @JacksonXmlProperty(localName = "ka")
        private Collection<String> k4;

        @JacksonXmlElementWrapper(localName = "k5", useWrapping = false)
        private Collection<String> k5;

        @JacksonXmlProperty(isAttribute = true)
        private Integer k6;

        private Value1 k7;
        private Value2 k8;

        @JacksonXmlCData(value = true) // 序列化时是否总是使用 CDATA 块
        private String k9;
     }

    @Setter
    @Getter
    private static class Value1 {
        @JacksonXmlText
        private String a;
    }

    @Setter
    @Getter
    private static class Value2 {
        @JacksonXmlText(value = false)     //子节点是否显示节点名称
        private String a;
    }
}
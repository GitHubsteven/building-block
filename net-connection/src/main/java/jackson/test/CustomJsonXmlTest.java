package jackson.test;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import xstream.generic.custom.test.Custom;
import xstream.generic.custom.test.Response;

import java.io.IOException;

/**
 * @author: jet.xie
 * @Date: 2018/9/26
 * @Description:
 * @version: 1.0.0
 */
public class CustomJsonXmlTest {
    private static final XmlMapper xmlMapper = new XmlMapper();

    static {

    }

    public static void main(String[] args) {
        String xml = "<alipay><name>response1</name><data><alipay><id>1</id><customId>123</customId></alipay></data></alipay>";
        try {
            Response<Custom> customXml = xmlMapper.readValue(xml, Response.class);
            System.out.println(customXml.getData().getData().getCustomId());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
package xstream.generic.custom.test;

import com.thoughtworks.xstream.XStream;

/**
 * @author: jet.xie
 * @Date: 2018/9/26
 * @Description:
 * @version: 1.0.0
 */
public class Test {
    public static void main(String[] args) {
        String xml = "<alipay><name>response1</name><data><id>1</id><customId>123</customId></data></alipay>";
//        XStream xStream = new XStream();
//        xStream.autodetectAnnotations(true);
//        xStream.processAnnotations(new Class[]{Response.class,Custom.class});
//        xStream.ignoreUnknownElements();
//        Response response = (Response<Custom>) xStream.fromXML(xml);
//
//        System.out.println(response.getData());

        XStream xStream = XStreamCreator.initXStream(Custom.class);
        Response<Custom> response = (Response<Custom>) xStream.fromXML(xml);
//        System.out.println(response.getData().getCustomId());
    }
}
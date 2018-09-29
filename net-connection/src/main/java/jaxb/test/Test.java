package jaxb.test;

import jaxb.teach.JAXBUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

/**
 * @author: jet.xie
 * @Date: 2018/9/27
 * @Description:
 * @version: 1.0.0
 */

public class Test {
    public static void main(String[] args) {

        Body body1 = new Body();
        body1.setDept("cs");
        body1.setName("cs-name");

        Body2 body2 = new Body2();
        Request req = new Request();
        req.setBody(body1);

        Request2 req2 = new Request2();
        req2.setBody(body2);

        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<Document>\n" +
                "    <request>\n" +
                "        <Body>\n" +
                "            <name>cs-name</name>\n" +
                "            <age>1</age>\n" +
                "        </Body>\n" +
                "    </request>\n" +
                "</Document>";

        Document doc = new Document();
        doc.setRequest(req);
        try {
            Document doc1 = JAXBUtils.unmarshal(xml, Document.class);
            System.out.println(doc1.getRequest().getBody().getClass());
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}

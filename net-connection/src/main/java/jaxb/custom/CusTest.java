package jaxb.custom;

import jaxb.teach.JAXBUtils;

import javax.xml.bind.JAXBException;

/**
 * @author: jet.xie
 * @Date: 2018/9/27
 * @Description:
 * @version: 1.0.0
 */
public class CusTest {
    public static void main(String[] args) {
        testBasedResponse();
    }





    private static void testBasedResponse() {
        CusBody cusBody = new CusBody();
        cusBody.setCusId("123");
        cusBody.setId(1L);
        CusResponse response = new CusResponse();
        response.setBody(cusBody);
        try {
            String xml = JAXBUtils.marshal(response);
            System.out.println(xml);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
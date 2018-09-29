package jaxb.teach;

import org.apache.commons.io.IOUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * @author: jet.xie
 * @Date: 2018/9/27
 * @Description:
 * @version: 1.0.0
 */
public class JAXBUtils {
    public final static String CHARSET_NAME = "UTF-8";

    public static String marshal(Object obj) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(obj.getClass());
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        // output pretty printed
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, CHARSET_NAME);

        StringWriter writer = new StringWriter();
        try {
            jaxbMarshaller.marshal(obj, writer);
            return writer.toString();
        } finally {
            IOUtils.closeQuietly(writer);
        }
    }

    public static <T> T unmarshal(String xml, Class<T> cls) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(cls);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        StringReader reader = null;
        try {
            reader = new StringReader(xml);
            return (T) jaxbUnmarshaller.unmarshal(reader);
        } finally {
            IOUtils.closeQuietly(reader);
        }
    }

}
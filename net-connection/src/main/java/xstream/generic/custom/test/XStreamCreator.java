package xstream.generic.custom.test;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * @author: jet.xie
 * @Date: 2018/9/26
 * @Description:
 * @version: 1.0.0
 */
public abstract class XStreamCreator {
    public static <T extends RespBase> XStream initXStream(Class<T> c) {
        XStream xstream = new XStream(new DomDriver());
        xstream.alias("alipay", Response.class);
        if (c.equals(Custom.class)) {
            xstream.alias("data", Custom.class);
        } else {
            xstream.alias("data", Query.class);
        }
        xstream = addAliases(xstream, c);
        return xstream;
    }

    // we want to process the annotations declared on type c
    protected static XStream addAliases(XStream xstream, Class<?> c) {
        while (c != null) {
            xstream.processAnnotations(c);
            c = c.getSuperclass();
        }
        return xstream;
    }
}
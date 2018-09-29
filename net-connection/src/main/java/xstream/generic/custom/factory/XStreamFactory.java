package xstream.generic.custom.factory;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * @author: jet.xie
 * @Date: 2018/9/26
 * @Description:
 * @version: 1.0.0
 */
class Response<T extends BaseDTO> {
    int id;
    T field;

    public int getId() {
        return id;
    }

    public T getField() {
        return field;
    }
}

class BaseDTO {
};

class B extends BaseDTO {
}

class C extends BaseDTO {
}

public abstract class XStreamFactory {
    public static <T extends BaseDTO> XStream initXStream(Class<T> c) {
        XStream xstream = new XStream(new DomDriver());
        xstream.alias("response-root", Response.class);
        if (c.equals(B.class)) {
            xstream.alias("specific-response-b", B.class);
        } else {
            xstream.alias("specific-response-c", C.class);
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
package xstream.generic.custom.test;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import org.springframework.util.Base64Utils;

/**
 * @author: jet.xie
 * @Date: 2018/9/26
 * @Description:
 * @version: 1.0.0
 */
public class ResponseConverter<T extends RespBase> extends Response implements Converter {
    @Override
    public void marshal(Object o, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {

    }

    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
//        String nodeName = reader.getNodeName();
//        Response<T> resp = new Response<>();
//        T data = resp.getData();
//        if ("data".equalsIgnoreCase(nodeName)) {
//            context.convertAnother(data, data.getClass());
//        }
//        return data;
        return null;
    }

    @Override
    public boolean canConvert(Class aClass) {
        return aClass.equals(RespBase.class);
    }
}
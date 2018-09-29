package xstream.generic.online.test;

import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

/**
 * @author: jet.xie
 * @Date: 2018/9/26
 * @Description:
 * @version: 1.0.0
 */
@XStreamConverter(FruitConvert.class)
public class FruitConvert extends Response<RETINFO> implements Converter {
    @Override
    public void marshal(Object o, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {

    }

    @Override
    public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        RetInfo_FRUITS retinfo = new RetInfo_FRUITS();
        unmarshallingContext.convertAnother(retinfo, retinfo.getClass());
        return retinfo;
    }

    @Override
    public boolean canConvert(Class aClass) {
        return aClass.equals(RETINFO.class);
    }


    public static void main(String[] args) {
        System.out.println(Object.class.isAssignableFrom(Integer.class));
        RetInfo_FRUITS retinfo = new RetInfo_FRUITS();
        System.out.println(retinfo.getClass());
    }
}
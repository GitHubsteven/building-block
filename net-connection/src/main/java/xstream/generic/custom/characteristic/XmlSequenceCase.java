package xstream.generic.custom.characteristic;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.reflection.FieldDictionary;
import com.thoughtworks.xstream.converters.reflection.PureJavaReflectionProvider;
import com.thoughtworks.xstream.converters.reflection.SortableFieldKeySorter;

import java.io.Serializable;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description: annotation order field when using XStream
 * zh: xstream 中指定序列化过程中属性的顺序
 * @Date: Created at 19:59 2019/2/20.
 */
public class XmlSequenceCase {
    //方式一，通过 com.thoughtworks.xstream.converters.reflection.FieldDictionary.
    //参考地址：https://www.programcreek.com/java-api-examples/index.php?api=com.thoughtworks.xstream.converters.reflection.FieldDictionary
    public void testSortsFieldOrderWithArray() {

        SortableFieldKeySorter sorter = new SortableFieldKeySorter();
        sorter.registerFieldOrder(MommyBear.class,
                new String[]{"absde", "absese", "accsed", "money"});

        XStream xstream = new XStream(new PureJavaReflectionProvider(new FieldDictionary(sorter)));
        xstream.alias("mommy", MommyBear.class);
        MommyBear root = new MommyBear();
        root.absde = "ccc";
        root.absese = "bbb";
        root.accsed = "aaa";
//        root.money = "12";
        System.out.println(xstream.toXML(root));
    }

    public static class MommyBear implements Serializable {
        String absde;
        String absese;
        String accsed;
        String money;
    }


    public void fieldSeqByAnnotation() {
        Buyer buyer = new Buyer();
        buyer.setImID("imId001");
        buyer.setZipCode("00001");
        buyer.setAddress("sh.cn");

        XStream xStream = new XStream(new PureJavaReflectionProvider(new FieldDictionary(new SequenceFieldKeySorter())));
        xStream.alias("buyer", Buyer.class);
        System.out.println(xStream.toXML(buyer));
    }

    public void partialFieldSeqByAnnotation() {
        Buyer buyer = new Buyer();
        buyer.setImID("imId001");
        buyer.setZipCode("00001");
        buyer.setAddress("sh.cn");

        XStream xStream = new XStream(new PureJavaReflectionProvider(new FieldDictionary(new PartialSeqFieldKeySorter())));
        xStream.alias("buyer", Buyer.class);
        System.out.println(xStream.toXML(buyer));
    }
}
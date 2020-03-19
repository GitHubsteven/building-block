package pers.demo.build.converter.jackson.xml;

import com.thoughtworks.xstream.XStream;

/**
 * @version 1.0.0
 * @author: rongbin.xie
 * @date: 2020/3/18
 * @CopyRight: COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class XStreamUtil {
    private static XStream xStream;

    static {
        xStream = XStreamCreator.buildXStream();
    }

    public static String toXml(Object obj) {
        return xStream.toXML(obj);
    }
}

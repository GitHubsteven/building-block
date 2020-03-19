package pers.demo.build.converter.jackson.xml;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

/**
 * @version 1.0.0
 * @author: rongbin.xie
 * @date: 2020/3/18
 * @CopyRight: COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class XmlUtils {
    private static XmlMapper xmlMapper;

    static {
        JacksonXmlModule module = new JacksonXmlModule();
        module.setDefaultUseWrapper(false);
        xmlMapper = new XmlMapper(module);
        //名称为snake_case
        xmlMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        xmlMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        //忽略空属性
        xmlMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        //忽略根类
        xmlMapper.disable(SerializationFeature.WRAP_ROOT_VALUE);
    }

    public static String toXml(final Object request) {
        try {
            return xmlMapper.writeValueAsString(request);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("parse bean to xml error", e);
        }
    }
}

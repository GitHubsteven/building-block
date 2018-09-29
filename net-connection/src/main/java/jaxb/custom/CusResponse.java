package jaxb.custom;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author: jet.xie
 * @Date: 2018/9/27
 * @Description:
 * @version: 1.0.0
 */
@XmlRootElement(name = "response")
public class CusResponse extends BaseResponse<CusBody> {
}
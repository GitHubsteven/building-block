package xstream.generic.custom.test;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: jet.xie
 * @Date: 2018/9/26
 * @Description:
 * @version: 1.0.0
 */
@Setter
@Getter
public class Custom extends RespBase {
    private String customId;
}
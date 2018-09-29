package xstream.generic.online.test;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: jet.xie
 * @Date: 2018/9/26
 * @Description:
 * @version: 1.0.0
 */
@XStreamAlias("FRUIT")
public class FRUIT {
    @XStreamAlias("Name")
    String Name = null;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
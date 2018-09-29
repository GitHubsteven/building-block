package xstream.generic.online.test;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.List;

/**
 * @author: jet.xie
 * @Date: 2018/9/26
 * @Description:
 * @version: 1.0.0
 */
@XStreamAlias("RETINFO")
public class RetInfo_FRUITS extends RETINFO {
    public RetInfo_FRUITS() {
    }

    @XStreamAlias("FRUITS")
    List<FRUIT> FRUITS = null;

    public List<FRUIT> getFRUITS() {
        return FRUITS;
    }

    public void setFRUITS(List<FRUIT> FRUITS) {
        this.FRUITS = FRUITS;
    }
}
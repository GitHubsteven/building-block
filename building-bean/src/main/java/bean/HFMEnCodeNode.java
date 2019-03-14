package bean;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description: huffman 编码和反编码
 * @Date: Created at 14:30 2019/3/14.
 */
@Setter
@Getter
public class HFMEnCodeNode<T extends Comparable<T>> extends ThreadedBiNode<T> {
    /**
     * 重量
     */
    private BigDecimal weight;
    /**
     * 编码
     */
    private String code;

    public HFMEnCodeNode(T val, BigDecimal weight) {
        super(val);
        this.weight = weight;
    }

    @Override
    public String custom2String() {
        return super.custom2String() + " code: " + code + " weight: " + weight.toString();
    }
}
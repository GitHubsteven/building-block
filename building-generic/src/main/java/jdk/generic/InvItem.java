package jdk.generic;

import org.springframework.util.StringUtils;

import java.io.Serializable;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 14:38 2018/11/22.
 */
public class InvItem implements Serializable {
    private String skuCode;
    private Integer quantity;

    public InvItem(final String skuCode, final Integer quantity) {
        this.skuCode = skuCode;
        this.quantity = quantity;
    }

    public InvItem() {
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(final String skuCode) {
        this.skuCode = skuCode;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(final Integer quantity) {
        this.quantity = quantity;
    }

    public void check() {
        if (StringUtils.isEmpty(skuCode)) {
            throw new IllegalArgumentException("skuCode不能为空");
        }
        if (quantity == null) {
            throw new IllegalArgumentException("quantity(物理库存)不能为空");
        }
    }
}
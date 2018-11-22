package jdk.generic;

import org.springframework.util.StringUtils;

import java.util.Arrays;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 15:01 2018/11/22.
 */
public class SNBaseOrderStatusBody extends BaseMessageBody<OrderStatusItem> {
    private static final String[] STATUSES = new String[]{
            "Shipped", "Locked", "Canceled"
    };

    @Override
    public void check() {
        int i = 1;
        for (final OrderStatusItem item : items) {
            if (StringUtils.isEmpty(item.getOrderNumber())) {
                throw new IllegalArgumentException(String.format("第%d项orderNumber不能为空!", i));
            }
            if (StringUtils.isEmpty(item.getOrderStatus()) || Arrays.binarySearch(STATUSES, item.getOrderStatus()) == -1) {
                throw new IllegalArgumentException(String.format("第%d项orderStatus不能为空,且可选值为[" + String.join(",", STATUSES) + "]", i));
            }
            if ("Shipped".equals(item.getOrderStatus()) && StringUtils.isEmpty(item.getOrderNumber())) {
                throw new IllegalArgumentException(String.format("第%d项当订单为Shipped时,trackingNumber不能为空!", i));
            }
            i++;
        }
    }
}
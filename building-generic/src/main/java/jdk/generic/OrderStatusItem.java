package jdk.generic;

import java.io.Serializable;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 14:37 2018/11/22.
 */
public class OrderStatusItem implements Serializable {
    /**
     * 订单编号
     */
    private String orderNumber;

    /**
     * 订单状态，目前有3种：'Shipped'，'Locked'，'Canceled'
     */
    private String orderStatus;

    /**
     * 运单号（物流查询用编号），如果订单状态为'Shipped'时必须有值
     */
    private String trackingNumber;

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(final String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(final String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(final String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public OrderStatusItem() {
    }

    public OrderStatusItem(final String orderNumber, final String orderStatus, final String trackingNumber) {
        this.orderNumber = orderNumber;
        this.orderStatus = orderStatus;
        this.trackingNumber = trackingNumber;
    }

    @Override
    public String toString() {
        return "OrderStatusItem{" +
                "orderNumber='" + orderNumber + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", trackingNumber='" + trackingNumber + '\'' +
                '}';
    }
}
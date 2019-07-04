package com.variety.shop.indi.design.pattern.factory;

/**
 * Created by rongbin.xie on 2017/10/16.
 */
public abstract class  WmsSkuMappingModel {
    /**
     * 渠道ID
     */
    protected String channelId;

    /**
     * 产品Code
     */
    protected String productCode;

    /**
     * UPC
     */
    protected String barcode;

    /**
     * SKU
     */
    protected String sku;

    /**
     * 产品名称
     */
    protected String productName;

    /**
     * 颜色
     */
    protected String color;

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

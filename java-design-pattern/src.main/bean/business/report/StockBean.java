package bean.business.report;

import java.math.BigDecimal;

public class StockBean {
    private String channelId;
    private String sku;
    private BigDecimal onHand;

    public String getChannelId() {
        return channelId;
    }

    public StockBean setChannelId(String channelId) {
        this.channelId = channelId;
        return this;
    }

    public String getSku() {
        return sku;
    }

    public StockBean setSku(String sku) {
        this.sku = sku;
        return this;
    }

    public BigDecimal getOnHand() {
        return onHand;
    }

    public StockBean setOnHand(BigDecimal onHand) {
        this.onHand = onHand;
        return this;
    }
}

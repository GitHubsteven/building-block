package bean.business.report;

import java.io.Serializable;

public class LogictisBean implements Serializable {
    private String name;
    private String sku;
    private String itemCode;

    public String getName() {
        return name;
    }

    public LogictisBean setName(String name) {
        this.name = name;
        return this;
    }

    public String getSku() {
        return sku;
    }

    public LogictisBean setSku(String sku) {
        this.sku = sku;
        return this;
    }

    public String getItemCode() {
        return itemCode;
    }

    public LogictisBean setItemCode(String itemCode) {
        this.itemCode = itemCode;
        return this;
    }
}

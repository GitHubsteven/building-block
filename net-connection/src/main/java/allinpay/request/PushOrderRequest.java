package allinpay.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description: 推送订单请求参数类
 * @Date: Created at 10:24 2018/10/30.
 */
@Setter
@Getter
public class PushOrderRequest extends BaseRequest {
    /**
     * PushTestOrder ,测试接口
     */
    public static final String service = "PushOrder";

    public PushOrderRequest() {
        super(service);
    }

    @JsonProperty("CapitalName")
    private String capitalName;
    @JsonProperty("CustomsCode")
    private String customsCode;
    @JsonProperty("MerchantName")
    private String merchantName;
    @JsonProperty("ReceiverMobile")
    private String receiverMobile;
    @JsonProperty("ItemNames")
    private String itemNames;
    @JsonProperty("OrderNo")
    private String orderNo;
    @JsonProperty("OrderTotal")
    private BigDecimal orderTotal;
    @JsonProperty("ReceiverCardNo")
    private String receiverCardNo;
    @JsonProperty("ReceiverName")
    private String receiverName;
    /**
     * 时间格式：2018-07-01 21:22:34
     */
    @JsonProperty("ShopPayTime")
    private String shopPayTime;
    @JsonProperty("TotalNum")
    private Integer totalNum;

}
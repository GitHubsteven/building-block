package allinpay.request;

import lombok.Getter;
import lombok.Setter;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description: 查询支付单接口请求参数
 * @Date: Created at 13:39 2018/10/30.
 */
@Getter
@Setter
public class PaymentNoCheckRequest extends BaseRequest {
    /**
     * GetTestOrder: 测试service
     */
    private static final String service = "GetOrder";
    private String OrderNo;
    private String MerchantName;

    public PaymentNoCheckRequest() {
        super(service);
    }
}
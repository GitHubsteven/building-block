package allinpay.response;

import allinpay.util.AllinpayConstant;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.StringUtils;

import java.util.Objects;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 fooVOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description: 支付单查询接口
 * @Date: Created at 13:42 2018/10/30.
 */
@Setter
@Getter
public class PaymentNoCheckResponse extends BaseResponse {
    @JsonProperty("CustomsMsg")
    private String customsMsg;
    @JsonProperty("OrderNo")
    private String orderNo;
    /**
     * 时间格式：2018-07-30 09:19:41
     */
    @JsonProperty("PayTime")
    private String payTime;
    @JsonProperty("PaymentMsg")
    private String paymentMsg;
    @JsonProperty("PaymentNo")
    private String paymentNo;
    @JsonProperty("PaymentStatus")
    private Integer paymentStatus;

    /**
     * 什么情况下支付+报关都是 OK 的
     * ReturnCode 为 0000
     * PaymentNo 不为空
     * CustomsMsg 为已支付+已报关
     *
     * @return 是否支付+报关都是 OK 的
     */
    public boolean isPayAndCusOk() {
        return isSuccess()
                && !StringUtils.isEmpty(paymentNo)
                && Objects.equals(customsMsg, AllinpayConstant.ResultCode.SUCCESS_CUSTOM_MSG);
    }
}
package allinpay.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description: 推送接口返回结果类
 * @Date: Created at 10:17 2018/10/30.
 */
@Setter
@Getter
public class PushOrderResponse extends BaseResponse {
    @JsonProperty("OrderNo")
    private String orderNo;
}
package allinpay.response;

import allinpay.util.AllinpayConstant;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description: 通联支付系统返回结果基础类
 * @Date: Created at 10:12 2018/10/30.
 */
@Setter
@Getter
public abstract class BaseResponse implements Serializable {
    @JsonProperty("ReturnCode")
    private String returnCode;
    @JsonProperty("ReturnMsg")
    private String returnMsg;
    private String originalText;

    public boolean isSuccess() {
        return AllinpayConstant.ResultCode.SUCCESS.equalsIgnoreCase(returnCode);
    }
}
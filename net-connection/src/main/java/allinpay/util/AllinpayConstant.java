package allinpay.util;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 10:47 2018/10/30.
 */
public class AllinpayConstant {
    public static final ObjectMapper OM = new ObjectMapper();

    public interface ResultCode {
        String SUCCESS = "0000";
        String SUCCESS_CUSTOM_MSG = "已支付+已报关";
    }
}
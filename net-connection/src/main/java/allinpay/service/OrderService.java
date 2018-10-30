package allinpay.service;

import allinpay.config.AllinpayConfig;
import allinpay.request.PaymentNoCheckRequest;
import allinpay.request.PushOrderRequest;
import allinpay.response.PaymentNoCheckResponse;
import allinpay.response.PushOrderResponse;
import org.springframework.stereotype.Service;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description: 通联订单相关业务逻辑实现类
 * @Date: Created at 10:43 2018/10/30.
 */
@Service
public class OrderService extends BaseService {
    /**
     * 订单推送接口
     *
     * @param request 请求参数
     * @param config  配置参数
     * @return 返回结果
     */
    public PushOrderResponse pushOder(PushOrderRequest request, AllinpayConfig config) {
        return execute(request, config, PushOrderResponse.class);
    }

    /**
     * 支付单查询接口
     *
     * @param request 请求参数
     * @param config  配置参数
     * @return 返回结果
     */
    public PaymentNoCheckResponse checkPaymentNo(PaymentNoCheckRequest request, AllinpayConfig config) {
        return execute(request, config, PaymentNoCheckResponse.class);
    }
}
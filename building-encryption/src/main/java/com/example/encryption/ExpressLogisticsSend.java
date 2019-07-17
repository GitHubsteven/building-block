package com.example.encryption;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 19:56 2019/7/3.
 */
@Getter
@Setter
public class ExpressLogisticsSend {
    /**
     * 闪电购订单Id（唯一标识）
     */
    private Long bizOrderId;
    /**
     * 快递物流单号
     */
    private String logisticsId;
    /**
     * 快递物流公司编号
     */
    private String companyCode;
    /**
     * 是否拆单，0:不拆单发货，1：拆单发货，此时必填subBizOrderIdList参数
     */
    private Integer isSplit;
    /**
     * 当isSplit为1时，该物流单对应过的子订单id
     */
    private List<Long> subBizOrderIdList;
}
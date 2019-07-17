package com.idv.asa.feign;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 13:27 2019/7/16.
 */
public class SignUtil {
    private final static ObjectMapper mapper = new ObjectMapper();
    private final static String APP_SECRET = "RT7I6gvghf#@&pKi";
    private final static String SIGN_METHOD = "md5";  //固定的默认的
    private final static String FORMAT = "json";
    private final static String APP_ID = "3510233";  //这个应该是固定的

    static {
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    @Test
    public void testCreateExpressSign() throws JsonProcessingException {
        ExpressLogisticsSend express = new ExpressLogisticsSend();
        express.setBizOrderId("302961088321");
        express.setCompanyCode("EMS");
        express.setIsSplit(1);
        express.setLogisticsId("9758136894007");
        //设置skuCodeList
        List<String> skuCodeList = Arrays.asList("863378", "863376", "863380");
        express.setSkuCodeList(skuCodeList);
        String sign = createSign(express, "trade.order.expressLogistics.send");
        System.out.println(sign);
    }

    @Test
    public void testCreateStockSign() throws JsonProcessingException {
        CenturyItemQty itemQty = new CenturyItemQty();
        itemQty.setOutItemId("21010160919");
        itemQty.setOutShopId("12");
        itemQty.setQuantity(11);
        String sign = createSign(itemQty, "stockcenter.item.quantity.updateByOutItemId");
        System.out.println(sign);
    }


    /**
     * 通过json来生成快递发货信息
     *
     * @param json 生成快递发货信息Json
     * @return 快递发货信息对象
     * @throws IOException
     */
    public static ExpressLogisticsSend expressLogistics(String json) throws IOException {
        return mapper.readValue(json, ExpressLogisticsSend.class);
    }

    /**
     * 生成签名的共同方法
     *
     * @param paramObj 参数对象
     * @param method   方法名称
     * @return 签名
     * @throws JsonProcessingException
     */
    public String createSign(Object paramObj, String method) throws JsonProcessingException {
        Map<String, String> paramsMap = new HashMap<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datetime = simpleDateFormat.format(new Date());
        paramsMap.put("appId", APP_ID);
        paramsMap.put("datetime", "2019-07-15 15:39:29");
        paramsMap.put("format", FORMAT);
        paramsMap.put("signMethod", SIGN_METHOD);
        paramsMap.put("method", method);
        String paramValue = mapper.writeValueAsString(paramObj);
        System.out.println(paramValue);
        paramsMap.put("param", paramValue);
        //将参数值改变为string，过滤非sign/sign_method/空值的参数
        String paramStr = paramsMap.entrySet().stream()
                .filter(it -> !"sign".equalsIgnoreCase(it.getKey()))
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .map(it -> it.getKey().concat(it.getValue()))
                .collect(Collectors.joining());
        String appSecret = APP_SECRET;   //这个需要改成自己配置的appSecret、也许是appkey
        System.out.println(String.format("------>APP_SECRET为：%s", appSecret));
        return DigestUtils.md5Hex(appSecret + DigestUtils.md5Hex(paramStr) + appSecret);
    }
}
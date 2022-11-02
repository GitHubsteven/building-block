package com.example.encryption;

import converter.json.jackson.JacksonUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.message.BasicNameValuePair;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 16:56 2019/7/4.
 */
public class FlashShipping {
    public static void main(String[] args) {
        Map<String, String> params = getParams();
        String calculatedSign = checkSign(params);
        System.out.println("calculated sign:" + calculatedSign);
        String sign = params.get("sign");
        System.out.println(sign);
        System.out.println(calculatedSign.equals(sign));
    }

    private static Map<String, String> getParams() {
        String json = "{\"datetime\":\"2019-05-31 15:46:10\",\"method\":\"trade.order.expressLogistics.send\",\"param\":\"{\\\"bizOrderId\\\":\\\"302961088321\\\",\\\"companyCode\\\":\\\"EMS\\\",\\\"isSplit\\\":1,\\\"logisticsId\\\":\\\"9758136894007\\\",\\\"skuCodeList\\\":[\\\"863378\\\",\\\"863376\\\",\\\"863380\\\"]}\",\"appId\":\"3510233\",\"format\":\"json\",\"sign\":\"1713de6c5ee17a890f02193e6f8f1d6a\",\"signMethod\":\"md5\"}";
        Map<String, Object> params = JacksonUtils.jsonToMap(json);
        Map<String, String> realParams = new HashMap<>();
        params.forEach((key, value) -> {
            realParams.put(key, (String) (value));
        });
        return realParams;
    }


    private static Map<String, String> getStringStringMap() {
        String json = "method:trade.order.expressLogistics.send\n" +
                "appId:3510233\n" +
                "datetime:2019-05-31 15:43:11\n" +
                "format:json\n" +
                "signMethod:md5\n" +
                "param:{\"bizOrderId\":\"302879688321\",\"companyCode\":\"EMS\",\"isSplit\":1,\"logisticsId\":\"9758136888207\",\"skuCodeList\":[\"863380\",\"863378\",\"863376\"]}\n" +
                "sign:5be76e06860eebe29391396c02cb632b";
        Map<String, String> params = new HashMap<>();
        for (String ele : json.split("\n")) {
            int firstIdx = ele.indexOf(":");
            params.put(ele.substring(0, firstIdx), ele.substring(firstIdx + 1));
        }
        return params;
    }

    /**
     * 检测入参
     *
     * @param paramsMap 检测的请求参数
     */
    public static String checkSign(Map<String, String> paramsMap) {
        //将参数值改变为string，过滤非sign/sign_method/空值的参数
        String paramStr = paramsMap.entrySet()
                .stream()
                .filter(it -> !"sign".equalsIgnoreCase(it.getKey())
                        && StringUtils.isNotBlank(it.getValue()))
                .map(it -> new BasicNameValuePair(it.getKey(), it.getValue()))
                .filter(it -> StringUtils.isNotBlank(it.getValue()))
                .sorted(Comparator.comparing(BasicNameValuePair::getName))
                .map(it -> it.getName() + it.getValue())
                .collect(Collectors.joining(""));
        String signMethod = paramsMap.get("signMethod");
        if (!"md5".equalsIgnoreCase(signMethod))
            throw new IllegalArgumentException("暂时只支持的MD5加密算法，当前传递算法参数为：" + signMethod);
        String appSecret = "HGD$HahaJLn2AkUo";
        return sign(paramStr, appSecret);
    }

    public static String sign(String json, String secret) {
        StringBuilder enValue = new StringBuilder();
        //前后加上secret
        //enValue.append(secret);
        enValue.append(json);
        //enValue.append(secret);
        // 使用MD5加密(32位小写)
        byte[] bytes = encryptMD5(enValue.toString());
        try {
            String str = byte2hex(bytes);
            StringBuilder enValue2 = new StringBuilder();
            //前后加上secret
            enValue2.append(secret);
            enValue2.append(str);
            enValue2.append(secret);
            // 使用MD5加密(32位小写)
            byte[] bytes1 = encryptMD5(enValue2.toString());
            return byte2hex(bytes1);
        } catch (Exception e) {
            return null;
        }
    }

    private static byte[] encryptMD5(String s) {
        return DigestUtils.md5(s);
    }

    private static String byte2hex(byte[] bytes) {
        return DigestUtils.md5Hex(bytes);
    }
}
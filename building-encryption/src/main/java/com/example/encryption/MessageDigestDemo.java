package com.example.encryption;

import com.google.gson.Gson;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.message.BasicNameValuePair;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 16:49 2019/7/3.
 */
public class MessageDigestDemo {
    /**
     * MessageDigest简介 : https://blog.csdn.net/hudashi/article/details/8394158
     */
    public String run(String text) throws NoSuchAlgorithmException {
        byte data[];
        MessageDigest messageDigest;
        try {
            data = text.getBytes(Charset.forName("UTF8"));
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(data);
            byte resultData[] = messageDigest.digest();
            return convertToHexString(resultData);
        } catch (NoSuchAlgorithmException e) {
            throw e;
        }
    }

    private static String convertToHexString(byte data[]) {
        StringBuilder strBuffer = new StringBuilder();
        for (byte aData : data) {
            strBuffer.append(Integer.toHexString(0xff & aData));
        }
        return strBuffer.toString();
    }

    private String md5sumWithEncoder(String text) throws NoSuchAlgorithmException,
            UnsupportedEncodingException {
        /*确定计算方法*/
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        /*加密后的散列码字符串*/
        String strMd5 = base64en.encode(md5.digest(text.getBytes("utf-8")));
        return strMd5;
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        MessageDigestDemo demo = new MessageDigestDemo();
        Object paramObj = getCenturyItemQty();

        Gson gson = new Gson();
        String param = gson.toJson(paramObj);
        Map<String, String> params = new HashMap<>();
        params.put("appId", "3517689");
        params.put("datetime", "2017-04-19 15:39:29");
        params.put("method", "stockcenter.item.quantity.updateByOutItemId");
        params.put("signMethod", "md5");
        params.put("format", "json");
        params.put("param", param);
        String sign = demo.checkSign(params);
        System.out.println(sign);
    }

    private static CenturyItemQty getCenturyItemQty() {
        CenturyItemQty itemQtyBean = new CenturyItemQty();
        itemQtyBean.setOutItemId("21010160919”");
        itemQtyBean.setOutShopId("12");
        itemQtyBean.setQuantity(11);
        return itemQtyBean;
    }

    static ExpressLogisticsSend getExpressLogistics() {
        ExpressLogisticsSend bean = new ExpressLogisticsSend();
        bean.setBizOrderId(1111111L);
        bean.setLogisticsId("170408000001");
        bean.setCompanyCode("POS");
        bean.setIsSplit(1);
        List<Long> subBizOrderIdList = new ArrayList<>();
        subBizOrderIdList.add(123456133L);
        subBizOrderIdList.add(56789234234L);
        bean.setSubBizOrderIdList(subBizOrderIdList);
        return bean;
    }


    /**
     * 检测入参
     *
     * @param paramsMap 检测的请求参数
     */
    public String checkSign(Map<String, String> paramsMap) {
        //将参数值改变为string，过滤非sign/sign_method/空值的参数
        String paramStr = paramsMap.entrySet()
                .stream()
                .filter(it -> !"sign".equalsIgnoreCase(it.getKey())
                        && !StringUtils.isNotBlank(it.getValue()))
                .map(it -> new BasicNameValuePair(it.getKey(), it.getValue()))
                .filter(it -> StringUtils.isNotBlank(it.getValue()))
                .sorted(Comparator.comparing(BasicNameValuePair::getName))
                .map(it -> it.getName() + it.getValue())
                .collect(Collectors.joining(""));
        String signMethod = paramsMap.get("signMethod");
        if (!"md5".equalsIgnoreCase(signMethod))
            throw new IllegalArgumentException("暂时只支持的MD5加密算法，当前传递算法参数为：" + signMethod);
        String appSecret = "HGD$HahaJLn2AkUo";
        return DigestUtils.md5Hex(appSecret + DigestUtils.md5Hex(paramStr) + appSecret);
    }

}
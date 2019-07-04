package com.example.encryption;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
        String str = "appId3517689datetime2017-04-19 15:39:29formatjsonmethodtrade.order.detail.getparam{\"bizOrderId\":\"200847030021\"}signMethodmd5";
        String appSecret = "HGD$HahaJLn2AkUo";
        String str2crypted = appSecret + demo.run(str) + appSecret;
        String sign = demo.run(str2crypted);
        System.out.println(sign);
    }
}
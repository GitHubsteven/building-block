package com.example.encryption;

import java.security.*;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 16:05 2019/7/3.
 */

public class MyDigest {
    public static void main(String[] args) {
        MyDigest my = new MyDigest();
        my.testDigest();
    }

    private void testDigest() {
        try {
            String myInfo = "我的测试信息";
//            java.security.MessageDigest alga=java.security.MessageDigest.getInstance("MD5");
            java.security.MessageDigest alga = java.security.MessageDigest.getInstance("SHA-1");
            alga.update(myInfo.getBytes());
            byte[] digesta = alga.digest();
            System.out.println("本信息摘要是 :" + byte2hex(digesta));
            // 通过某中方式传给其他人你的信息 (myInfo) 和摘要 (digesta) 对方可以判断是否更改或传输正常
            java.security.MessageDigest algb = java.security.MessageDigest.getInstance("SHA-1");
            algb.update(myInfo.getBytes());
            if (MessageDigest.isEqual(digesta, algb.digest())) {
                System.out.println("信息检查正常");
            } else {
                System.out.println("摘要不相同");
            }
        } catch (java.security.NoSuchAlgorithmException ex) {
            System.out.println("非法摘要算法");
        }
    }

    private String byte2hex(byte[] b) // 二行制转字符串
    {
        StringBuilder hs = new StringBuilder();
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1) hs.append("0").append(stmp);
            else hs.append(stmp);
            if (n < b.length - 1) hs.append(":");
        }
        return hs.toString().toUpperCase();
    }
}
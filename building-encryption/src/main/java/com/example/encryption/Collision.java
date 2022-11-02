package com.example.encryption;

import sun.misc.MessageUtils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/12/23
 * @description：hash冲突
 * @copyright COPYRIGHT © 2014 - 2021/5/18 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class Collision {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("md5");
        String message = "hello,world";
        md5.update(message.getBytes(StandardCharsets.UTF_8));
        System.out.println(md5.toString());
    }
}

package com.variety.shop.exception;

import java.security.NoSuchAlgorithmException;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 10:56 2019/7/4.
 */
public class ExceptionDemo1 {
    public static void main(String[] args) {
        try {
            doBusiness(4);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("------> algorithm exception");
        } catch (RuntimeException e) {
            System.out.println("------> runtime exception");
        } finally {
            //无论是否抛出异常，都会异常
            System.out.println("--------->finally");
        }
        System.out.println("---------->other");
    }

    static void doBusiness(int isUnNormal) throws NoSuchAlgorithmException {
        if (isUnNormal == 0)
            throw new RuntimeException("test exception!");
        else if (isUnNormal == 1) {
            throw new NoSuchAlgorithmException("test algori exception!");
        }

    }
}
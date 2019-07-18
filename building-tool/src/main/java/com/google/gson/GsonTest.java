package com.google.gson;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 14:47 2019/7/18.
 */
public class GsonTest {
    @Test
    public void testSerializeInterface() {
        List<String> skus = new ArrayList<>();
        skus.add("1");
        System.out.println(serialize(skus));
    }

    public String serialize(Collection<String> skus) {
        Gson gson = new Gson();
        return gson.toJson(skus);
    }
}
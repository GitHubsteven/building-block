package http.connect.pool;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/12/28
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class InterruptRequestTest {
    public static void main(String[] args) {
        HttpUriRequest request = new HttpGet("");
        request.abort();
    }
}

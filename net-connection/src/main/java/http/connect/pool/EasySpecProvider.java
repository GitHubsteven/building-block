package http.connect.pool;

import org.apache.http.cookie.CookieSpec;
import org.apache.http.cookie.CookieSpecProvider;
import org.apache.http.protocol.HttpContext;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/1/12
 * @description
 * @copyright COPYRIGHT © 2014 - 2021 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class EasySpecProvider implements CookieSpecProvider {
    @Override
    public CookieSpec create(HttpContext context) {
        return null;
    }
}

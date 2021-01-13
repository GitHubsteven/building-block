package http.connect.pool;

import org.apache.http.cookie.ClientCookie;
import org.apache.http.impl.cookie.BasicClientCookie;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/1/12
 * @description 文档链接：https://hc.apache.org/httpcomponents-client-ga/tutorial/html/statemgmt.html#d5e499
 * @copyright COPYRIGHT © 2014 - 2021 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class HttpCookiesTest {
    public static void main(String[] args) {
        BasicClientCookie cookie = new BasicClientCookie("name", "value");
        // Set effective domain and path attributes
        cookie.setDomain(".mycompany.com");
        cookie.setPath("/");
        cookie.setAttribute(ClientCookie.PATH_ATTR, "/");
        cookie.setAttribute(ClientCookie.DOMAIN_ATTR, ".mycompany.com");
    }
}

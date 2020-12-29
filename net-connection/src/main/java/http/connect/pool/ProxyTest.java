package http.connect.pool;

import org.apache.http.HttpHost;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
import org.apache.http.impl.conn.SystemDefaultRoutePlanner;

import java.net.ProxySelector;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/12/29
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class ProxyTest {
    public static void main(String[] args) {
        final HttpHost proxy = new HttpHost("proxy-001", 8080);
        final DefaultProxyRoutePlanner routePlanner = new DefaultProxyRoutePlanner(proxy);
        final CloseableHttpClient httpClient = HttpClients.custom()
                .setRoutePlanner(routePlanner)
                .build();

        SystemDefaultRoutePlanner systemDefaultRoutePlanner = new SystemDefaultRoutePlanner(
                ProxySelector.getDefault());

        final CloseableHttpClient systemHttpClient = HttpClients.custom()
                .setRoutePlanner(systemDefaultRoutePlanner)
                .build();

        final HttpRoutePlanner customRoutePlanner = (target, request, context)
                -> new HttpRoute(target, null, proxy, "https".equalsIgnoreCase(target.getSchemeName()));

        HttpClients.custom()
                .setRoutePlanner(customRoutePlanner)
                .build();
    }
}

package http.connect.pool;

import org.apache.http.client.CookieStore;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.util.PublicSuffixMatcher;
import org.apache.http.conn.util.PublicSuffixMatcherLoader;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.CookieSpec;
import org.apache.http.cookie.CookieSpecProvider;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.impl.cookie.DefaultCookieSpecProvider;
import org.apache.http.impl.cookie.RFC6265CookieSpecProvider;

import java.io.IOException;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/1/12
 * @description url:https://hc.apache.org/httpcomponents-client-ga/tutorial/html/statemgmt.html#d5e499
 * @copyright COPYRIGHT © 2014 - 2021 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class CustomCookiePolicyTest {
    public static void main(String[] args) {

        final PublicSuffixMatcher publicSuffixMatcher = PublicSuffixMatcherLoader.getDefault();
        final Registry<CookieSpecProvider> r = RegistryBuilder.<CookieSpecProvider>create()
                .register(CookieSpecs.DEFAULT, new DefaultCookieSpecProvider(publicSuffixMatcher))
                .register(CookieSpecs.STANDARD,
                        new RFC6265CookieSpecProvider(publicSuffixMatcher))
                .register("easy", new EasySpecProvider())
                .build();

        final RequestConfig requestConfig = RequestConfig.custom()
                .setCookieSpec("easy")
                .build();

        CloseableHttpClient httpclient = HttpClients.custom()
                .setDefaultCookieSpecRegistry(r)
                .setDefaultRequestConfig(requestConfig)
                .build();

        // create a local instance of cookie store
        CookieStore cookieStore = new BasicCookieStore();
        // populate cookie if needed
        BasicClientCookie cookie = new BasicClientCookie("name", "value");
        cookie.setDomain(".mycompany.com");
        cookie.setPath("/");
        cookieStore.addCookie(cookie);

        // set the store
        final CloseableHttpClient httpClient = HttpClients.custom()
                .setDefaultCookieStore(cookieStore)
                .build();

        // http client
        HttpGet httpget = new HttpGet("http://somehost/");
        HttpClientContext context = HttpClientContext.create();
        context.setCookieStore(cookieStore);
        context.setCookieSpecRegistry(r);
        try {
            final CloseableHttpResponse response = httpClient.execute(httpget);
            final CookieOrigin cookieOrigin = context.getCookieOrigin();
            final CookieSpec cookieSpec = context.getCookieSpec();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

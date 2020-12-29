package http.connect.pool;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

import java.io.IOException;

/**
 * url: http://ifeve.com/%e3%80%8ahttpclient%e5%ae%98%e6%96%b9%e6%96%87%e6%a1%a3%e3%80%8b1-3-http%e6%89%a7%e8%a1%8c%e4%b8%8a%e4%b8%8b%e6%96%87/
 *
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/12/28
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class HttpContextTest {

    private static CloseableHttpClient httpclient = HttpClients.createDefault();

    public static void main(String[] args) throws IOException {
        HttpContext context = new BasicHttpContext();
        final HttpClientContext clientContext = HttpClientContext.adapt(context);

        final HttpHost target = clientContext.getTargetHost();
        final HttpRequest request = clientContext.getRequest();
        final HttpResponse response = clientContext.getResponse();
        final RequestConfig config = clientContext.getRequestConfig();

        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(1000)
                .setConnectTimeout(1000)
                .build();

        HttpGet httpGet1 = new HttpGet("http://localhost/1");
        httpGet1.setConfig(requestConfig);

        final CloseableHttpResponse response1 = httpclient.execute(httpGet1, context);

        try {
            final HttpEntity entity1 = response1.getEntity();
        } catch (Exception e) {
            response1.close();
        }
        // response 2
        HttpGet httpGet2 = new HttpGet("http://localhost/2");
        CloseableHttpResponse response2 = httpclient.execute(httpGet2, context);
        try {
            HttpEntity entity2 = response2.getEntity();
        } finally {
            response2.close();
        }
    }
}

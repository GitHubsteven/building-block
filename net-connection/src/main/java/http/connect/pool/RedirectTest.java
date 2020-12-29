package http.connect.pool;

import org.apache.http.HttpHost;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.LaxRedirectStrategy;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/12/28
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class RedirectTest {
    public static void main(String[] args) throws IOException {
        final LaxRedirectStrategy redirectStrategy = new LaxRedirectStrategy();
        final CloseableHttpClient httpClient = HttpClients.custom()
                .setRedirectStrategy(redirectStrategy)
                .build();

        final CloseableHttpClient httpClient1 = HttpClients.createDefault();
        final HttpClientContext context = HttpClientContext.create();
        HttpGet httpget = new HttpGet("http://localhost:8080/");

        try (CloseableHttpResponse response = httpClient1.execute(httpget, context)) {
            final HttpHost target = context.getTargetHost();
            final List<URI> redirectLocations = context.getRedirectLocations();
            URI location = URIUtils.resolve(httpget.getURI(), target, redirectLocations);
            System.out.println("Final HTTP location: " + location.toASCIIString());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}

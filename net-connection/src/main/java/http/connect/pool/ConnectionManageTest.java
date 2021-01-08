package http.connect.pool;

import org.apache.http.HttpClientConnection;
import org.apache.http.HttpHost;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ConnectionPoolTimeoutException;
import org.apache.http.conn.ConnectionRequest;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/12/30
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class ConnectionManageTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException, IOException {
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        // Increase max total connection to 200
        cm.setMaxTotal(200);
        // Increase default max connection per route to 20
        cm.setDefaultMaxPerRoute(20);
        // Increase max connections for localhost:80 to 50
        HttpHost localhost = new HttpHost("locahost", 80);
        cm.setMaxPerRoute(new HttpRoute(localhost), 50);
        CloseableHttpClient httpClient = HttpClients.custom()
                .setConnectionManager(cm)
                .build();
        HttpGet request = new HttpGet("localhost://test//demo");
        httpClient.execute(request);
    }

    private static void manage() throws InterruptedException, ExecutionException, ConnectionPoolTimeoutException {
        HttpClientContext context = HttpClientContext.create();
        HttpClientConnectionManager connMrg = new BasicHttpClientConnectionManager();
        HttpRoute route = new HttpRoute(new HttpHost("localhost", 80));
        // Request new connection. This can be a long process
        final ConnectionRequest connRequest = connMrg.requestConnection(route, null);
        final HttpClientConnection conn = connRequest.get(10, TimeUnit.SECONDS);
        try {
            if (!conn.isOpen()) {
                connMrg.connect(conn, route, 1000, context);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            connMrg.releaseConnection(conn, null, 1, TimeUnit.MINUTES);
        }
    }
}

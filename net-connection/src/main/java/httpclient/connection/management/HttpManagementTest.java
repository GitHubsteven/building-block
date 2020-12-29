package httpclient.connection.management;

import lombok.SneakyThrows;
import org.apache.http.*;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.ConnectionRequest;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpRequestExecutor;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/12/16
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class HttpManagementTest {

    public static void main(String[] args) {

    }

    public static void basicConnection() {
        BasicHttpClientConnectionManager connManager
                = new BasicHttpClientConnectionManager();
        HttpRoute route = new HttpRoute(new HttpHost("www.baeldung.com", 80));
        ConnectionRequest connRequest = connManager.requestConnection(route, null);
    }

    /**
     * Setting the PoolingHttpClientConnectionManager on a HttpClient
     *
     * @throws IOException
     */
    public static void poolingConnection() throws IOException {
        HttpClientConnectionManager poolingConnManager
                = new PoolingHttpClientConnectionManager();
        CloseableHttpClient client
                = HttpClients.custom().setConnectionManager(poolingConnManager)
                .build();
        client.execute(new HttpGet("/"));
//        assertTrue(poolingConnManager.getTotalStats().getLeased() == 1);
    }

    public static void towHttpClient4Con() throws InterruptedException {
        HttpGet get1 = new HttpGet("/");
        HttpGet get2 = new HttpGet("http://google.com");
        PoolingHttpClientConnectionManager connManager
                = new PoolingHttpClientConnectionManager();
        CloseableHttpClient client1
                = HttpClients.custom().setConnectionManager(connManager).build();
        CloseableHttpClient client2
                = HttpClients.custom().setConnectionManager(connManager).build();

        MultiHttpClientConnThread thread1
                = new MultiHttpClientConnThread(client1, get1, connManager);
        MultiHttpClientConnThread thread2
                = new MultiHttpClientConnThread(client2, get2, connManager);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }

    public static void configureConnectionManager() {
        PoolingHttpClientConnectionManager connManager
                = new PoolingHttpClientConnectionManager();
        connManager.setMaxTotal(5);
        connManager.setDefaultMaxPerRoute(4);
        HttpHost host = new HttpHost("www.baeldung.com", 80);
        connManager.setMaxPerRoute(new HttpRoute(host), 5);
    }

    public static void thread4Conn() throws InterruptedException {
        HttpGet get = new HttpGet("http://www.baeldung.com");
        PoolingHttpClientConnectionManager connManager
                = new PoolingHttpClientConnectionManager();
        CloseableHttpClient client = HttpClients.custom().
                setConnectionManager(connManager).build();
        MultiHttpClientConnThread thread1
                = new MultiHttpClientConnThread(client, get, connManager);
        MultiHttpClientConnThread thread2
                = new MultiHttpClientConnThread(client, get, connManager);
        MultiHttpClientConnThread thread3
                = new MultiHttpClientConnThread(client, get, connManager);
        thread1.start();
        thread2.start();
        thread3.start();
        thread1.join();
        thread2.join();
        thread3.join();
    }

    public static void keepAliveStrategy(){
        ConnectionKeepAliveStrategy myStrategy = new ConnectionKeepAliveStrategy() {
            @Override
            public long getKeepAliveDuration(HttpResponse response, HttpContext context) {
                HeaderElementIterator it = new BasicHeaderElementIterator
                        (response.headerIterator(HTTP.CONN_KEEP_ALIVE));
                while (it.hasNext()) {
                    HeaderElement he = it.nextElement();
                    String param = he.getName();
                    String value = he.getValue();
                    if (value != null && param.equalsIgnoreCase
                            ("timeout")) {
                        return Long.parseLong(value) * 1000;
                    }
                }
                return 5 * 1000;
            }
        };

        PoolingHttpClientConnectionManager connManager
                = new PoolingHttpClientConnectionManager();
        CloseableHttpClient client = HttpClients.custom()
                .setKeepAliveStrategy(myStrategy)
                .setConnectionManager(connManager)
                .build();
    }

    public static void persistenceOrReuseConnection() throws InterruptedException, ExecutionException, IOException, HttpException {
        BasicHttpClientConnectionManager basicConnManager =
                new BasicHttpClientConnectionManager();

        HttpClientContext context = HttpClientContext.create();

        // low level
        HttpRoute route = new HttpRoute(new HttpHost("www.baeldung.com", 80));
        ConnectionRequest connRequest = basicConnManager.requestConnection(route, null);
        HttpClientConnection conn = connRequest.get(10, TimeUnit.SECONDS);
        basicConnManager.connect(conn, route, 1000, context);
        basicConnManager.routeComplete(conn, route, context);

        HttpRequestExecutor exeRequest = new HttpRequestExecutor();
        context.setTargetHost((new HttpHost("www.baeldung.com", 80)));
        HttpGet get = new HttpGet("http://www.baeldung.com");
        exeRequest.execute(get, conn, context);

        basicConnManager.releaseConnection(conn, null, 1, TimeUnit.SECONDS);

        // high level
        CloseableHttpClient client = HttpClients.custom()
                .setConnectionManager(basicConnManager)
                .build();
        client.execute(get);
    }

    public static void reuse() throws InterruptedException {
        HttpGet get = new HttpGet("http://echo.200please.com");
        PoolingHttpClientConnectionManager connManager
                = new PoolingHttpClientConnectionManager();
        connManager.setDefaultMaxPerRoute(5);
        connManager.setMaxTotal(5);
        CloseableHttpClient client = HttpClients.custom()
                .setConnectionManager(connManager)
                .build();
        MultiHttpClientConnThread[] threads
                = new  MultiHttpClientConnThread[10];
        for(int i = 0; i < threads.length; i++){
            threads[i] = new MultiHttpClientConnThread(client, get, connManager);
        }
        for (MultiHttpClientConnThread thread: threads) {
            thread.start();
        }
        for (MultiHttpClientConnThread thread: threads) {
            thread.join(1000);
        }
    }

    public static void timeout(){
        HttpRoute route = new HttpRoute(new HttpHost("www.baeldung.com", 80));
        PoolingHttpClientConnectionManager connManager
                = new PoolingHttpClientConnectionManager();
        connManager.setSocketConfig(route.getTargetHost(), SocketConfig.custom().
                setSoTimeout(5000).build());
    }

    public static void evictConnection(){
        PoolingHttpClientConnectionManager connManager
                = new PoolingHttpClientConnectionManager();
        CloseableHttpClient client = HttpClients.custom().setDefaultRequestConfig(
                RequestConfig.custom().setStaleConnectionCheckEnabled(true).build()
        ).setConnectionManager(connManager).build();
    }

    public static void staleConnectionMonitor() throws InterruptedException {
        PoolingHttpClientConnectionManager connManager
                = new PoolingHttpClientConnectionManager();
        CloseableHttpClient client = HttpClients.custom()
                .setConnectionManager(connManager)
                .build();
        IdleConnectionMonitorThread staleMonitor
                = new IdleConnectionMonitorThread(connManager);
        staleMonitor.start();
        staleMonitor.join(1000);
    }

    @SneakyThrows
    public static void closeConnection() throws IOException {
        PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager();
        CloseableHttpClient client = HttpClients.custom()
                .setConnectionManager(connManager).build();
        HttpGet get = new HttpGet("http://google.com");
        CloseableHttpResponse response = client.execute(get);

        EntityUtils.consume(response.getEntity());
        response.close();
        client.close();
        connManager.close();
    }
}

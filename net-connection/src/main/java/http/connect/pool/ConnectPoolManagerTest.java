package http.connect.pool;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * http://ifeve.com/http-connection-pool/
 *
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/12/25
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class ConnectPoolManagerTest {
    private static HttpClient httpClient = null;

    static {
        init();
    }

    public static void main(String[] args) {
        doRequest();
    }

    public static void init() {
        //1.创建连接池管理器
        //1.1
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(60000,
                TimeUnit.MILLISECONDS);
        //1.2
        connectionManager.setMaxTotal(1000);
        //1.3
        connectionManager.setDefaultMaxPerRoute(50);

        //2.创建httpclient对象
        httpClient = HttpClients.custom()
                //2.1
                .setConnectionManager(connectionManager)
                //2.2
                .disableAutomaticRetries()
                .build();
    }

    public static void doRequest() {
        HttpResponse response = null;
        //3.创建请求对象
        try {
            final HttpGet httpGet = new HttpGet("https://www.baidu.com/");

            RequestConfig.Builder builder = RequestConfig.custom();
            //3.1设置客户端等待服务端返回数据的超时时间
            builder.setSocketTimeout(3000)
                    //3.2设置客户端发起TCP连接请求的超时时间
                    .setConnectTimeout(1000)
                    //3.3设置客户端从连接池获取链接的超时时间
                    .setConnectionRequestTimeout(3000);
            httpGet.setConfig(builder.build());

            //4.发起请求
            response = httpClient.execute(httpGet);

            if (response.getStatusLine().getStatusCode() == 200) {
                final String result = EntityUtils.toString(response.getEntity());
                System.out.println(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != response) {
                try {
                    EntityUtils.consume(response.getEntity());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

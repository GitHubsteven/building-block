package http.connect.pool;

import org.apache.commons.io.FileUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import java.io.File;
import java.io.IOException;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/12/15
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class DefaultPoolTest {
    public final static String TEMPLATE = "https://qiniufile.voyageone.com.cn/is/image/sneakerhead/%s?imageView2/0/w/800/h/800/format/jpg";

    public static void main(String[] args) throws IOException {
        final String url = String.format(TEMPLATE, "928-A77-182870387754991-1");
        executeWithDefaultHttpClient(url);
    }


    public static void executeWithDefaultHttpClient(String url) throws IOException {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            final HttpGet httpGet = new HttpGet(url);
            try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
                File targetFile = new File("H:\\workplace-save\\image001.jpg");
                FileUtils.copyInputStreamToFile(response.getEntity().getContent(), targetFile);
            }
        }
    }

    public static void executeWithPooled(String url) throws IOException {
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(100);
        connectionManager.setDefaultMaxPerRoute(20);

        try (CloseableHttpClient httpClient = HttpClients.custom()
                .setConnectionManager(connectionManager)
//                .setDefaultHeaders("","")
                .build()) {
            final HttpGet httpGet = new HttpGet(url);
            try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
                File targetFile = new File("H:\\workplace-save\\image001.jpg");
                FileUtils.copyInputStreamToFile(response.getEntity().getContent(), targetFile);
            }
        }
    }

    public static void executeWithPooledUsingHttpClientBuilder(String url) throws Exception {
        try (CloseableHttpClient httpClient = HttpClients.custom()
                .setMaxConnTotal(100)
                .setMaxConnPerRoute(20)
                .build()) {
            final HttpGet httpGet = new HttpGet(url);
            try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
                File targetFile = new File("H:\\workplace-save\\image001.jpg");
                FileUtils.copyInputStreamToFile(response.getEntity().getContent(), targetFile);
            }
        }
    }
}

package http.connect.pool;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/12/15
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class KeepAliveRequestTest {
    public final static String TEMPLATE = "https://qiniufile.voyageone.com.cn/is/image/sneakerhead/%s?imageView2/0/w/800/h/800/format/jpg";
    public final static HttpClient httpClient = HttpClients.createDefault();
    public static HttpClient longHttpClient;

    static {
        List<Header> headers = new ArrayList<>();
        headers.add(new BasicHeader("Connection", "Keep-Alive"));
        longHttpClient = HttpClients.custom()
                .setDefaultHeaders(headers)
                .build();
    }

    public static void main(String[] args) throws Exception {
//        loopRunner(KeepAliveRequestTest::runWithDefault);
//        loopRunner(KeepAliveRequestTest::runWithKeepAlive);
//        final String url = String.format(TEMPLATE, "928-A77-182870387754991-1");
//        runWithKeepAlive(url);
        loopRunner(KeepAliveRequestTest::originalRunner);
    }

    private static void loopRunner(Consumer<String> consumer) {
        final String url = String.format(TEMPLATE, "928-A77-182870387754991-1");
        List<String> result = new ArrayList<>();
        for (Integer loop : Arrays.asList(10, 100, 1000, 10000)) {
            final long start = System.currentTimeMillis();
            for (int i = 0; i < loop; i++) {
                consumer.accept(url);
            }
            final long cost = System.currentTimeMillis() - start;
            result.add(String.format("loop: %d, cost: %s(ms)", loop, cost));
        }
        result.forEach(System.out::println);
    }


    public static void runWithDefault(String url) {
        HttpGet httpGet = new HttpGet(url);
        try {
            HttpResponse resp = httpClient.execute(httpGet);
            StatusLine statusLine = resp.getStatusLine();
            int statusCode = statusLine.getStatusCode();
            if (statusCode == 200) {
                String respStr = EntityUtils.toString(resp.getEntity());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void runWithKeepAlive(String url) {
        HttpGet httpGet = new HttpGet(url);
        try {
            HttpResponse resp = longHttpClient.execute(httpGet);
            StatusLine statusLine = resp.getStatusLine();
            int statusCode = statusLine.getStatusCode();
            if (statusCode == 200) {
                String respStr = EntityUtils.toString(resp.getEntity());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void originalRunner(String imageUrl) {
        try {
            URL url = new URL(imageUrl);
            try (InputStream is = url.openStream();) {
                StreamUtils.copyToString(is, StandardCharsets.UTF_8);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

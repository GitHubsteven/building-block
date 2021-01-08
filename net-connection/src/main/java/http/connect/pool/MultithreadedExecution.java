package http.connect.pool;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.protocol.HttpContext;

import java.io.IOException;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/12/30
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class MultithreadedExecution {
    public static void main(String[] args) {

    }


    static class GetThread extends Thread {
        private final CloseableHttpClient httpClient;
        private final HttpContext context;
        private HttpGet httpGet;

        public GetThread(CloseableHttpClient httpClient, HttpGet httpget) {
            this.httpClient = httpClient;
            this.context = HttpClientContext.create();
            this.httpGet = httpget;
        }

        @Override
        public void run() {
            try {
                try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
                    final HttpEntity entity = response.getEntity();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

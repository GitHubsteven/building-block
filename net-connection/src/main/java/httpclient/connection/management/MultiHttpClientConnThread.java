package httpclient.connection.management;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/12/16
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class MultiHttpClientConnThread extends Thread {
    private CloseableHttpClient client;
    private HttpGet get;

    public MultiHttpClientConnThread(CloseableHttpClient client1, HttpGet get1, PoolingHttpClientConnectionManager connManager) {
        this.client = client1;
        this.get = get1;
    }


    @Override
    public void run() {
        try {
            HttpResponse response = client.execute(get);
            EntityUtils.consume(response.getEntity());
        } catch (IOException ignored) {
        }
    }
}

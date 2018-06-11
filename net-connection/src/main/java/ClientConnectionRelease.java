import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/6/8
 * @Time: 20:11
 * @Description: * This example demonstrates the recommended way of using API to make sure
 * * the underlying connection gets released back to the connection manager.
 * @version: 1.0.0
 */

public class ClientConnectionRelease {
    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpClient = HttpClientUtils.buildHttpClient();
        HttpGet httpget = new HttpGet("https://www.baidu.com/");
        CloseableHttpResponse response = httpClient.execute(httpget);
        String HALVING_LINE = "---------------------------------";
        System.out.println(HALVING_LINE);
        try {
            StatusLine statusLine = response.getStatusLine();
            System.out.println(statusLine);
            System.out.println(HALVING_LINE);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                try (InputStream inputStream = entity.getContent()) {
                    inputStream.read();
                }
            }
        } finally {
            httpClient.close();
        }

    }
}
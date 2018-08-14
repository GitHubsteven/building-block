import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/7/6
 * @Time: 19:58
 * @Description:
 * @version: 1.0.0
 */
public class UrlTest {
    public static void main(String[] args) {
        try {
            URI uri = new URIBuilder()
                    .setScheme("http")
                    .setHost("www.google.com")
                    .setPath("/search")
                    .setParameter("q", "httpclient")
                    .setParameter("btnG", "Google search")
                    .setParameter("aq", "f")
                    .setParameter("oq", "")
                    .build();
            HttpGet httpGet = new HttpGet(uri);
            HttpClient httpClient = HttpClients.createDefault();
            HttpResponse response = httpClient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                InputStream content = entity.getContent();
                InputStreamReader isReader = new InputStreamReader(content, "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(isReader);
                StringBuilder sb = new StringBuilder();
                while (bufferedReader.readLine() != null) {
                    sb.append(bufferedReader.readLine());
                }
                System.out.println(sb.toString());
            }
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }
}
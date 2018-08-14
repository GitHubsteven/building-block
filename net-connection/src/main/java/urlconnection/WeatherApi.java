package urlconnection;

import com.sun.javafx.fxml.builder.URLBuilder;
import common.BaseApiCall;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.DefaultBHttpClientConnectionFactory;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/8/14
 * @Time: 11:26
 * @Description:
 * @version: 1.0.0
 */
public class WeatherApi extends BaseApiCall {
    private static final String API_URL = "https://www.sojson.com/open/api/weather/json.shtml?";

    public static void main(String[] args) {
        Map<String, Object> params = new HashMap<>();
        try {
            URI uri = new URIBuilder().setScheme("https")
                    .setHost("www.sojson.com")
                    .setPath("/open/api/weather/json.shtml")
                    .setParameter("city", "上海")
                    .build();
//
//            URI uri = new URIBuilder()
//                    .setHost("https://blog.csdn.net/u010714901")
//                    .build();
            callApiByURI(uri);
        } catch (Exception e) {
            System.out.println("调用api失败");
        }
    }

    public static void callApiByURI(URI uri) throws Exception {

        HttpGet httpGet = new HttpGet(String.valueOf(uri.toURL()));
        HttpClient httpClient = HttpClients.createDefault();
        HttpResponse resp = httpClient.execute(httpGet);
        StatusLine statusLine = resp.getStatusLine();
        int statusCode = statusLine.getStatusCode();
        if (statusCode == 200) {
            String respStr = EntityUtils.toString(resp.getEntity());
//            String respStr = fromHttpEntity2String(resp.getEntity());
            System.out.println(respStr);
        }

    }


}
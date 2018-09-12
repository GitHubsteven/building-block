package httplcient;

import com.sun.javafx.fxml.builder.URLBuilder;
import org.apache.commons.lang.CharSet;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.config.Lookup;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.util.PublicSuffixMatcher;
import org.apache.http.conn.util.PublicSuffixMatcherLoader;
import org.apache.http.cookie.*;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.impl.cookie.DefaultCookieSpecProvider;
import org.apache.http.impl.cookie.RFC6265CookieSpecProvider;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import static org.apache.http.client.config.CookieSpecs.DEFAULT;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/9/12
 * @Time: 11:22
 * @Description:
 * @version: 1.0.0
 */
public class CookieRequestSimulator {
    public static void main(String[] args) {
        try {
            String respStr = testCookie();
            System.out.println(respStr);
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }

    private static String testCookie() throws URISyntaxException, IOException {
        URI uri = new URIBuilder()
                .setHost("localhost")
                .setPort(8085)
                .setScheme("HTTP")
                .setPath("/asa-web-demo/testCookie")
                .setParameter("option", "add")
                .build();
        HttpGet httpGet = new HttpGet(uri);
        httpGet.addHeader("Accept", "image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, application/x-shockwave-flash, application/x-silverlight, ** ");
        httpGet.addHeader("Accept-Language", "zh-cn ");
        httpGet.addHeader("UA-CPU", "x86 ");
        httpGet.addHeader("Accept-Encoding", "gzip, deflate");
        httpGet.addHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1) ");
        httpGet.addHeader("Connection", "Keep-Alive");
        httpGet.addHeader("Cookie", "cool=yeah!");
        BasicClientCookie cookie = new BasicClientCookie("name", "value");

        RequestConfig globalConfig = RequestConfig.custom()
                .setCookieSpec(CookieSpecs.DEFAULT)
                .build();
        CloseableHttpClient httpclient = HttpClients.custom()
                .setDefaultRequestConfig(globalConfig)
                .build();
        RequestConfig localConfig = RequestConfig.copy(globalConfig)
                .setCookieSpec(CookieSpecs.STANDARD_STRICT)
                .build();
        httpGet.setConfig(localConfig);

        CookieStore cookieStore = new BasicCookieStore();
        cookieStore.addCookie(cookie);
        HttpClientContext context = HttpClientContext.create();
//        context.setCookieSpecRegistry(cookieSpecReg);
        context.setCookieStore(cookieStore);

        CloseableHttpResponse response1 = httpclient.execute(httpGet, context);
        // Cookie origin details
        CookieOrigin cookieOrigin = context.getCookieOrigin();
        // Cookie spec used
        CookieSpec cookieSpec = context.getCookieSpec();
        return null;
    }
}
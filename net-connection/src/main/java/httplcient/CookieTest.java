package httplcient;

import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.util.PublicSuffixMatcher;
import org.apache.http.conn.util.PublicSuffixMatcherLoader;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.cookie.CookieSpecProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.impl.cookie.DefaultCookieSpecProvider;
import org.apache.http.impl.cookie.RFC6265CookieSpecProvider;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/9/12
 * @Time: 13:35
 * @Description:
 * @version: 1.0.0
 */
public class CookieTest {
    public static void main(String[] args) {

    }

    public void testCookie(){
        BasicClientCookie cookie = new BasicClientCookie("name", "value");
// Set effective domain and path attributes
        cookie.setDomain(".mycompany.com");
        cookie.setPath("/");
// Set attributes exactly as sent by the server
        cookie.setAttribute(ClientCookie.PATH_ATTR, "/");
        cookie.setAttribute(ClientCookie.DOMAIN_ATTR, ".mycompany.com");

        RequestConfig globalConfig = RequestConfig.custom()
                .setCookieSpec(CookieSpecs.DEFAULT)
                .build();

        RequestConfig localConfig = RequestConfig.copy(globalConfig)
                .setCookieSpec(CookieSpecs.STANDARD_STRICT)
                .build();
        HttpGet httpGet = new HttpGet("/");
        httpGet.setConfig(localConfig);

        PublicSuffixMatcher publicSuffixMatcher = PublicSuffixMatcherLoader.getDefault();

        Registry<CookieSpecProvider> r = RegistryBuilder.<CookieSpecProvider>create()
                .register(CookieSpecs.DEFAULT,
                        new DefaultCookieSpecProvider(publicSuffixMatcher))
                .register(CookieSpecs.STANDARD,
                        new RFC6265CookieSpecProvider(publicSuffixMatcher))
//                .register("easy", new EasySpecProvider())
                .build();

        RequestConfig requestConfig = RequestConfig.custom()
                .setCookieSpec("easy")
                .build();

        CloseableHttpClient httpclient = HttpClients.custom()
                .setDefaultCookieSpecRegistry(r)
                .setDefaultRequestConfig(requestConfig)
                .build();
    }
}
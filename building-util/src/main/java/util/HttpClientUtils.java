package util;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.net.URLConnection;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/6/8
 * @Time: 17:31
 * @Description:
 * @version: 1.0.0
 */
public class HttpClientUtils {

    public static CloseableHttpClient buildHttpClient(){
        return HttpClients.createDefault();
    }
}
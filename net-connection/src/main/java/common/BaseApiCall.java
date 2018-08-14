package common;

import org.apache.http.HttpEntity;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/8/14
 * @Time: 13:58
 * @Description:
 * @version: 1.0.0
 */
public abstract class BaseApiCall {

    public static String callApi(Map<String, Object> params, URL url) throws Exception {
        URLConnection conn = url.openConnection();
        conn.connect();
        BufferedReader innet = new BufferedReader(new InputStreamReader(
                conn.getInputStream(),
                "UTF-8"));
        StringBuilder result = new StringBuilder();
        String line;
        while ((line = innet.readLine()) != null) {
            result.append(line);
        }
        innet.close();
//        System.out.println(result);
        return result.toString();
    }


    public static String fromHttpEntity2String(HttpEntity entity) throws Exception {
        InputStream content = entity.getContent();
        InputStreamReader isReader = new InputStreamReader(content, "UTF-8");
        BufferedReader bufferedReader = new BufferedReader(isReader);
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            sb.append(line);
        }
        return sb.toString();
    }
}
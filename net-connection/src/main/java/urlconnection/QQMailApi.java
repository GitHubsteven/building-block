package urlconnection;

import common.BaseApiCall;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.BasicPermission;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/8/14
 * @Time: 16:06
 * @Description:
 * @version: 1.0.0
 */
public class QQMailApi extends BaseApiCall {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://en.mail.qq.com/cgi-bin/frame_html?sid=E4wADx2QKavZlwZd&r=4be672d660cecdf67429741d164d11ea");
            String result = callApi(new HashMap<>(), url);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("api call error");
        }

    }
}
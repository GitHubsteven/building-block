package urlconnection;

import common.BaseApiCall;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/8/14
 * @Time: 15:51
 * @Description:
 * @version: 1.0.0
 */
public class CSDNApi extends BaseApiCall {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://blog.csdn.net/u010714901");
            String result = callApi(new HashMap<>(), url);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
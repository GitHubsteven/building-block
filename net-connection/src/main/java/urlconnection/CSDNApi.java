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
            URL url = new URL("https://mapi.alipay.com/gateway.do?_input_charset=utf-8&amount=100&customs_place=HZ&merchant_customs_code=test_customs_code&merchant_customs_name=test_customs_name&out_request_no=test_out_request_no&pattern=2088521406728162&service=alipay.acquire.customs&sign=1ba1efd9ebb964f510c71cd71001fd5b&sign_type=MD5&trade_no=test_trade_no");
            String result = callApi(new HashMap<>(), url);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
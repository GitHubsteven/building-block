package basic;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ApiCallProcess {
    private final static String HOST_URL = "https://www.apiopen.top/addStatistics";

    /**
     * 模拟请求客户端
     */
    private static final HttpClient client = HttpClients.createDefault();

    /**
     * 管理网络请求http://hc.apache.org/httpcomponents-client-ga/fluent-hc/apidocs/org/apache/http/client/fluent/Executor.html
     * <p>
     * An Executor for fluent requests.
     * <p>
     * A PoolingHttpClientConnectionManager with maximum 100 connections per route and a total maximum of 200 connections is used internally.
     */
    private static final Executor executor = Executor.newInstance(client);

    public static void main(String[] args) {
        Request request = buildBasicRequest(HOST_URL);
        try {
            //执行网络请求
            Response response = executor.execute(request);
            HttpResponse returnResponse = response.returnResponse();
            String respJson = EntityUtils.toString(returnResponse.getEntity());
//            判断返回结果的http status值，可以根据自己的需求来写
            int statusCode = returnResponse.getStatusLine().getStatusCode();
            //定义合理的状态值
            if (statusCode < HttpStatus.SC_OK || statusCode > HttpStatus.SC_MULTIPLE_CHOICES) {
                throw new RuntimeException("调用api结果返回状态码不对！值为：" + statusCode);
            }
            System.out.println("------------调用api返回结果为：" + respJson);
        } catch (IOException e) {
            throw new RuntimeException("调用api出现io异常", e);
        }
    }

    /**
     * 创建一个基本请求，参数可随需求变化
     *
     * @param url 请求地址
     * @return 基本请求
     */
    private static Request buildBasicRequest(String url) {
        List<BasicNameValuePair> params = getParams();
        String paramByString = URLEncodedUtils.format(params, "UTF-8");
        //建立一个Get的请求，带有默认信息，
        Request request = Request.Get(url + "?" + paramByString);
//        request.bodyString(paramByString, ContentType.APPLICATION_FORM_URLENCODED);
        return request;
    }

    /**
     * 获取参数
     *
     * @return 参数list, 为了更好的可读性
     */
    public static List<BasicNameValuePair> getParams() {
        ArrayList<BasicNameValuePair> params = new ArrayList<>();
        //id=27610708&page=1
        params.add(new BasicNameValuePair("appKey", "00d91e8e0cca2b76f515926a36db68f5"));
        params.add(new BasicNameValuePair("type", "点击统计"));
        params.add(new BasicNameValuePair("typeId", "1"));
        params.add(new BasicNameValuePair("count", "2"));
        return params;
    }

}
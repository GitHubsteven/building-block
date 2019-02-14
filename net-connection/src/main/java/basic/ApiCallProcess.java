package basic;

import converter.json.jackson.JacksonUtils;
import org.apache.commons.io.Charsets;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        //执行这个方法，如果是get请求的话
//        sendRequest(buildGetRequest(HOST_URL));
        //如果是json post请求的话，那么执行下面这个方法
//        sendRequest(buildPost());
        //如果是 表单post请求的话，那么执行下面这个方法
        sendRequest(buildPostForm());
    }

    /**
     * get 请求方法实例
     */
    private static void sendRequest(Request request) {
//        Request request = buildBasicRequest(HOST_URL);
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
    private static Request buildGetRequest(String url) {
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


    /**
     * 基于post接口 http://httpbin.org/post
     * request参数：
     * {
     * "username": "vip",
     * "password": "secret"
     * }
     * 返回结果：
     * {
     * "args": {},
     * "data": "{\"username\":\"vip\",\"password\":\"secret\"}",
     * "files": {},
     * "form": {},
     * "headers": {
     * "Accept": "application/json",
     * "Connection": "close",
     * "Content-Length": "38",
     * "Content-Type": "application/json",
     * "Encoding": "UTF-8",
     * "Host": "httpbin.org"
     * },
     * "json": {
     * "password": "secret",
     * "username": "vip"
     * },
     * "origin": "222.73.202.154",
     * "url": "http://httpbin.org/post"
     * }
     */
    public static Request buildPost() {
        String url = "http://httpbin.org/post";
        Request postReq = Request.Post(url);
        PostParam postParam = new PostParam("vip", "secret");
        //设置bodyString
        postReq.bodyString(JacksonUtils.bean2JsonNotNull(postParam), ContentType.APPLICATION_JSON.withCharset(Charsets.UTF_8));
        return postReq;
    }

    /**
     * 基于post接口 http://httpbin.org/post  表单类型请求
     * request参数：
     * "form": {
     * "password": "secret",
     * "username": "vip"
     * },
     * 返回结果：
     * {
     * "args": {},
     * "data": "",
     * "files": {},
     * "form": {
     * "password": "secret",
     * "username": "vip"
     * },
     * "headers": {
     * "Connection": "close",
     * "Content-Length": "28",
     * "Content-Type": "application/x-www-form-urlencoded",
     * "Encoding": "UTF-8",
     * "Host": "httpbin.org"
     * },
     * "json": null,
     * "origin": "222.73.202.154",
     * "url": "http://httpbin.org/post"
     * }
     */
    public static Request buildPostForm() {
        String url = "http://httpbin.org/post";
        Request postReq = Request.Post(url);
        PostParam postParam = new PostParam("vip", "secret");
        List<BasicNameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("username", "vip"));
        params.add(new BasicNameValuePair("password", "secret"));
        //设置bodyString
        postReq.bodyString(joinParam2String(params), ContentType.APPLICATION_FORM_URLENCODED.withCharset(Charsets.UTF_8));
        return postReq;
    }

    /**
     * 表单参数拼接
     *
     * @param params 参数
     * @return
     */
    private static String joinParam2String(List<BasicNameValuePair> params) {
        return params.stream()
                .map(param -> {
                    //也许这里要对value进行url值转化，但是这里不考虑
                    return param.getName() + "=" + param.getValue();
                }).collect(Collectors.joining("&"));
    }

    /**
     * 映射为表单的参数格式
     *
     * @param el 参数
     * @return string类型参数
     */
    private static String map2String(Map.Entry<String, Object> el) {
        String key = el.getKey();
        Object value = el.getValue();
        return key + "=" + value;
    }

    static class PostParam {
        private String username;
        private String password;

        public PostParam(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

}
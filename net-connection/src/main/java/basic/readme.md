在工作日常中，跨平台api对接是再正常不过的事情了，例如，需要调用api，这个api：[免费api](https://www.apiopen.top/addStatistics?appKey=00d91e8e0cca2b76f515926a36db68f5&type=点击统计&typeId=1&count=2) ，这是个免费的获取天气信息Get Api。
为了调用这个api，我们需要使用Apache的网络通信java包：org.apache.http.client.fluent，通常我们建立一个网络请求的话，我们需要做如下事情：

 -  指定请求协议，http 或者https
 -  指定host
 - 指定path
 - 指定代理
 - 指定超时规定
 - 指定参数
 - 指定方法的类型，get/post/delete/put等等

但是为了简化我们的开发，我们一般会使用默认的，上面只是为了说明基本的请求需要做什么！

1. 创建一个客户端模拟对象
	```
	  /**
	     * 模拟请求客户端
	     */
	    private static final HttpClient client = HttpClients.createDefault();
	```

 2. 为了避免网络请求资源过多，我们需要使用执行器，就像多线程一样
	```
	   private static final Executor executor = Executor.newInstance(client);
	```
	官方文档[链接](http://hc.apache.org/httpcomponents-client-ga/fluent-hc/apidocs/org/apache/http/client/fluent/Executor.html)是这么说的官方文档[链接](http://hc.apache.org/httpcomponents-client-ga/fluent-hc/apidocs/org/apache/http/client/fluent/Executor.html)是这么说的
	> An Executor for fluent requests.
	> A PoolingHttpClientConnectionManager with maximum 100 connections per route and a total maximum of 200 connections is used internally.
	
	大概意思就是一个带有最大200的网络链接的限制的执行者。

好了，基本的辅助类，我们引入了，那么我们需要开始分析请求了，请求的全部地址为：
```
https://www.apiopen.top/addStatistics?appKey=00d91e8e0cca2b76f515926a36db68f5&type=点击统计&typeId=1&count=2
```
分析结果为：
| 属性 |值  |
|--|--|
|  协议|  https|
|  dns域名（可以说是地址了）|  www.apiopen.top|
|  path|  addStatistics|
|  请求类型|  get|
|  请求参数1|  appKey=00d91e8e0cca2b76f515926a36db68f5|
|  请求参数2|  type=点击统计|
|  请求参数3|  typeId=1|
|  请求参数4|  count=2|

**url = 协议+dns:https://www.apiopen.top/addStatistics**

1. 因为是Get方法，所以我们需要建立一个Get的基本请求：
	```
	    Request request = Request.Get(url);
	```
2. 因为要传递参数，同时避免参数值url中不合法，我们需要使用一个辅助类来转码：
	```
	  List<BasicNameValuePair> params = getParams();
       String paramByString = URLEncodedUtils.format(params, "UTF-8");
	```
3. 使用执行器来发送请求，获取结果
代码如下：
	 ```
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
	 ```
 最后代码：
```
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
```


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

| 属性        | 值           | 
| ------------- |:-------------:| 
| 协议     | https | 
| dns域名（可以说是地址了）| www.apiopen.top      |  
| path | /addStatistics     |   
|  请求类型|  get|
|  请求参数1|  appKey=00d91e8e0cca2b76f515926a36db68f5|
|  请求参数2|  type=点击统计|
|  请求参数3|  typeId=1|
|  请求参数4|  count=2|

##### Get api的调用
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
##### Post Api的调用
然而在post的Api中，可能会有些许不同（但是上面的模拟客户端和创建执行者，解析url的步骤是一样的），因为在post中，参数不是拼接在url后面用“？”相加起来的，我们需要把参数用另外一种方式来放在Request中，基于如下接口信息
```
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
```

1. 建立post的基本请求
	```
	 String url = "http://httpbin.org/post";
        Request postReq = Request.Post(url);
        PostParam postParam = new PostParam("vip", "secret");
        //设置bodyString
        postReq.bodyString(JacksonUtils.bean2JsonNotNull(postParam), 		ContentType.APPLICATION_JSON.withCharset(Charsets.UTF_8));
        return postReq;
	```
	 **设置bodyString** 
	```
	 postReq.bodyString(JacksonUtils.bean2JsonNotNull(postParam), 		ContentType.APPLICATION_JSON.withCharset(Charsets.UTF_8));
	```
	bodyString的参数根据需求有不同的设值：
	
	| post类型|第一个值  |第二个值  |
	| ------------- |:-------------:| ------------- |
	| application/x-www-form-urlencoded|username=vip&password=secret  | ContentType.APPLICATION_FORM_URLENCODED.withCharset(Charsets.UTF_8)| |
	| application/json|{"username":"vip","password":"secret"}  | ContentType.APPLICATION_JSON.withCharset(Charsets.UTF_8)|
      
2. 执行上面的第三步
当post类型为application/json时运行结果如下：
```
------------调用api返回结果为：{
  "args": {}, 
  "data": "{\"username\":\"vip\",\"password\":\"secret\"}", 
  "files": {}, 
  "form": {}, 
  "headers": {
    "Accept-Encoding": "gzip,deflate", 
    "Connection": "close", 
    "Content-Length": "38", 
    "Content-Type": "application/json; charset=UTF-8", 
    "Host": "httpbin.org", 
    "User-Agent": "Apache-HttpClient/4.5.5 (Java/1.8.0_101)"
  }, 
  "json": {
    "password": "secret", 
    "username": "vip"
  }, 
  "origin": "222.73.202.154", 
  "url": "http://httpbin.org/post"
}
```
当post类型是 application/x-www-form-urlencoded，运行结果为：
```
{
  "args": {}, 
  "data": "", 
  "files": {}, 
  "form": {
    "password": "secret", 
    "username": "vip"
  }, 
  "headers": {
    "Accept-Encoding": "gzip,deflate", 
    "Connection": "close", 
    "Content-Length": "28", 
    "Content-Type": "application/x-www-form-urlencoded; charset=UTF-8", 
    "Host": "httpbin.org", 
    "User-Agent": "Apache-HttpClient/4.5.5 (Java/1.8.0_101)"
  }, 
  "json": null, 
  "origin": "222.73.202.154", 
  "url": "http://httpbin.org/post"
}
```

 最后代码：
https://github.com/GitHubsteven/building-block/blob/master/net-connection/src/main/java/basic/ApiCallProcess.java


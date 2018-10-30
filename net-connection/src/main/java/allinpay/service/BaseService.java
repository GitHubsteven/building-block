package allinpay.service;

import allinpay.config.AllinpayConfig;
import allinpay.exception.AllinpayApiException;
import allinpay.request.BaseRequest;
import allinpay.response.BaseResponse;
import allinpay.util.AllinpayConstant;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 10:43 2018/10/30.
 */
public class BaseService  {
    /**
     * 这里定制http client
     */
    private static final HttpClient client = HttpClients.createDefault();

    private static final Executor executor = Executor.newInstance(client);

    public <T extends BaseResponse> T execute(BaseRequest request, AllinpayConfig config, Class<T> clz) {
        Request req = buildReq(request, config);
        String respJson;
        try {
            Response response = executor.execute(req);
            HttpResponse httpResponse = response.returnResponse();
            HttpEntity entity = httpResponse.getEntity();
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            respJson = EntityUtils.toString(entity);
            if (statusCode < HttpStatus.SC_OK || statusCode > HttpStatus.SC_MULTIPLE_CHOICES) {
                throw new AllinpayApiException(String.format("http response status code %s is not in [200,300)," +
                        "response:%s", statusCode, respJson));
            }
            if (StringUtils.isEmpty(respJson)) {
                throw new AllinpayApiException("response body is empty");
            }
//            $info("respJson:{}", respJson);
            T resp = AllinpayConstant.OM.readValue(respJson, clz);
            //如果返回结果封装失败的话，抛出异常。
            if (!resp.isSuccess()) {
                String errMsg = String.format("fail to call api(service:%s)，error：%s， response:%s",
                        request.getService(), resp.getReturnMsg(), respJson);
                throw new AllinpayApiException(errMsg);
            }
            resp.setOriginalText(respJson);
            return resp;
        } catch (IOException e) {
            throw new AllinpayApiException("io exception,the responseBody is null,please see the cause exception ", e);
        }
    }

    /**
     * 根据请求穿件http request
     *
     * @param request 请求参数
     * @return http请求
     */
    private Request buildReq(BaseRequest request, AllinpayConfig config) {
        String host = config.getEndpoint();
        //设置地址
        Request req = Request.Post(host + "/" + request.getService());
        //设置参数
        Map<String, Object> formParam = new HashMap<>();
        try {
            String data = AllinpayConstant.OM.writeValueAsString(request);
            formParam.put("data", data);
        } catch (JsonProcessingException e) {
            throw new AllinpayApiException("生成post请求参数时出现异常!");
        }
//        $info("{}请求参数为：{}", request.getService(), formParam.toString());
        req.bodyString(joinParam2String(formParam), ContentType.APPLICATION_FORM_URLENCODED.withCharset(StandardCharsets.UTF_8));

        if (config.hasProxy()) {
            req.viaProxy(HttpHost.create(config.getProxy()));
        }
        if (config.getConnectTimeout() != null) {
            req.connectTimeout(config.getConnectTimeout());
        }
        if (config.getSocketTimeout() != null) {
            req.socketTimeout(config.getSocketTimeout());
        }
        return req;
    }

    private String joinParam2String(Map<String, Object> params) {
        List<Map.Entry<String, Object>> sortedParams = params.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .collect(Collectors.toList());
        List<String> sortedParmsInStr = new ArrayList<>();
        for (Map.Entry<String, Object> entry : sortedParams) {
            sortedParmsInStr.add(map2String(entry));
        }
        return sortedParmsInStr.stream()
                .collect(Collectors.joining("&"));
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
}
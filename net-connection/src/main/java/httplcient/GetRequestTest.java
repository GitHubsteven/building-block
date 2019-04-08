package httplcient;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.Serializable;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 16:06 2019/4/2.
 */
public class GetRequestTest {
    private static final ObjectMapper OM = new ObjectMapper();

    //因为当前的接受Response只有两个字段，所以是需要这个，如果以后要比较详细的话，那么再根据需求改变
    static {
        OM.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    /**
     * 这里定制http client
     */
    private static final HttpClient client = HttpClientBuilder.create().build();
    private static final Executor executor = Executor.newInstance(client);

    public static void main(String[] args) throws Exception {
        String url = "localhost:8080/wms/test/get-json-obj";
        Request req = Request.Get(url);
        Person request = new Person("get.request.json", 12);
        StringEntity stringEntity = new StringEntity(OM.writeValueAsString(request), ContentType.APPLICATION_JSON);
        req.body(stringEntity);

        Response resp = executor.execute(req);
        HttpResponse httpResp = resp.returnResponse();
        HttpEntity entity = httpResp.getEntity();
        String respStr = EntityUtils.toString(entity);
        System.out.println(respStr);
    }

    @Setter
    @Getter
    @AllArgsConstructor
    static class Person implements Serializable {
        private String name;
        private Integer age;
    }
}
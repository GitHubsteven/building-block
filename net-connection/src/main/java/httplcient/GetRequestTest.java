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
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
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
//    199456 (ms)
    private static final HttpClient client = HttpClientBuilder.create().build();
    private static final Executor executor = Executor.newInstance(client);

    public static void main(String[] args) throws Exception {
        String url = "https://qiniufile.voyageone.com.cn/is/image/sneakerhead/928-A57-I0002622-1";
        Request req = Request.Get(url);
//        Person request = new Person("get.request.json", 12);
//        StringEntity stringEntity = new StringEntity(OM.writeValueAsString(request), ContentType.APPLICATION_JSON);
//        req.body(stringEntity);
        String destinationFile = "H:\\temp\\image%s.jpg";
        final long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            Response resp = executor.execute(req);
            HttpResponse httpResp = resp.returnResponse();
            HttpEntity entity = httpResp.getEntity();
            final InputStream is = entity.getContent();
            OutputStream os = new FileOutputStream(String.format(destinationFile, i));

            byte[] b = new byte[2048];
            int length;

            while ((length = is.read(b)) != -1) {
                os.write(b, 0, length);
            }

            is.close();
            os.close();
        }
        System.out.println((System.currentTimeMillis() - start) + " (ms)");

//        String respStr = EntityUtils.toString(entity);
//        System.out.println(respStr);


    }

    @Setter
    @Getter
    @AllArgsConstructor
    static class Person implements Serializable {
        private String name;
        private Integer age;
    }
}
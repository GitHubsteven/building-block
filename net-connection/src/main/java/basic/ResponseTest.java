package basic;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.message.BasicHttpResponse;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/7/6
 * @Time: 20:05
 * @Description:
 * @version: 1.0.0
 */
public class ResponseTest {
    public static void main(String[] args) {
        HttpResponse httpResponse = new BasicHttpResponse(HttpVersion.HTTP_1_1, HttpStatus.SC_OK, "ok");
        httpResponse.addHeader("Set-cookie","c1=a;path=/;domain=localhost");
        httpResponse.addHeader("Set-cookie","c2=b;path=/;domain=localhost");
        Header firstHeader = httpResponse.getFirstHeader("Set-cookie");
        Header lastHeader = httpResponse.getLastHeader("Set-cookie");
        System.out.println(firstHeader.getValue());

    }
}
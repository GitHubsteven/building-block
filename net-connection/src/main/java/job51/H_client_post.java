package job51;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;



public class H_client_post {

    public static void main(String[] args) throws IOException {

        HttpClient client = new HttpClient();

        PostMethod method = new PostMethod("http://192.168.111.128/bak/login_post.php");

//表单域的值,既post传入的key=value

        NameValuePair[] date = { new NameValuePair("username","admin"),new NameValuePair("password","123457")};

//method使用表单阈值

        method.setRequestBody(date);

//提交表单

        client.executeMethod(method);

//字符流转字节流 循环输出，同get解释

        InputStream inputStream = method.getResponseBodyAsStream();

        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));

        StringBuffer stringBuffer = new StringBuffer();

        String str= "";

        while((str = br.readLine()) != null){

            stringBuffer .append(str );

        }

        System.out.println(stringBuffer.toString());

        method.releaseConnection();

    }

}
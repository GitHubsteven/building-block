package job51;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;



public class H_client_get {

    public static void main(String[] args) throws IOException {

// new类对象

        HttpClient client = new HttpClient();

// 使用 GET 方法 与URL服务器进行交互

// HttpMethod method = new GetMethod("http://192.168.111.128/bak/regist.php?email=admin@admin.com&password=1234567&re_password=1234567&username=admin&nickname=管理员");

        HttpMethod method = new GetMethod("http://192.168.111.128/bak/login.php?username=");

// 使用 GET 方法 ，实行与url服务器连接

        client.executeMethod(method);

// 数据流输出

// method.getResponseBodyAsStream 创建字节流对象为inputStream

        InputStream inputStream = method.getResponseBodyAsStream();

// InputStreamReader(inputStream)字节流转换成字符流 BufferedReader封装成带有缓冲的字符流对象了

        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));

// StringBuffer是字符串变量，它的对象是可以扩充和修改的 创建一个空的StringBuffer类的对象

        StringBuffer stringBuffer = new StringBuffer();

// 定义字符串常量

        String str= "";

// br字符流赋值给str字符串常量 str不等于空 按行输出

        while((str = br.readLine()) != null){

// StringBuffer 是字符串变量，它的对象是可以扩充和修改的 将str数据赋予 stringBuffer

            stringBuffer .append(str );

        }

// 按照字符串循环输出stringBuffer

        System.out.println(stringBuffer.toString());

// 关闭method 的 httpclient连接

        method.releaseConnection();

    }

}
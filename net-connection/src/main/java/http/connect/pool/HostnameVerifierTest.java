package http.connect.pool;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.util.PublicSuffixMatcher;
import org.apache.http.conn.util.PublicSuffixMatcherLoader;
import org.apache.http.ssl.SSLContexts;
import sun.net.www.protocol.https.DefaultHostnameVerifier;

import javax.net.ssl.SSLContext;
import java.io.IOException;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/12/29
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class HostnameVerifierTest {
    public static void main(String[] args) throws IOException {
        DefaultHostnameVerifier defaultHostnameVerifier = new DefaultHostnameVerifier();
        final SSLContext sslContext = SSLContexts.createDefault();
        final SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, NoopHostnameVerifier.INSTANCE);

        PublicSuffixMatcher publicSuffixMatcher = PublicSuffixMatcherLoader.load(
                PublicSuffixMatcher.class.getResource("my-copy-effective_tld_names.dat"));
        DefaultHostnameVerifier hostnameVerifier = new DefaultHostnameVerifier();
    }
}

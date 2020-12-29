package http.connect.pool;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.ssl.TrustStrategy;

import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/12/29
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class SSLorTLSTest {
    public static void main(String[] args) throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
        KeyStore myTrustStore = KeyStore.getInstance(KeyStore.getDefaultType());
        TrustStrategy trustStrategy = new TrustSelfSignedStrategy();
        SSLContext sslContext = SSLContexts.custom()
                .loadTrustMaterial(myTrustStore, trustStrategy)
                .build();

        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext);
    }
}

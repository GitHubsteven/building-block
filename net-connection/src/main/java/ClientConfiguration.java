import org.apache.http.*;
import org.apache.http.config.MessageConstraints;
import org.apache.http.conn.ManagedHttpClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.DefaultHttpResponseFactory;
import org.apache.http.impl.conn.ManagedHttpClientConnectionFactory;
import org.apache.http.impl.io.DefaultHttpRequestWriterFactory;
import org.apache.http.impl.io.DefaultHttpResponseParser;
import org.apache.http.impl.io.DefaultHttpResponseParserFactory;
import org.apache.http.io.*;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicLineParser;
import org.apache.http.message.LineParser;
import org.apache.http.util.CharArrayBuffer;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/6/8
 * @Time: 20:24
 * @Description: This example demonstrates how to customize and configure the most common aspects
 * of HTTP request execution and connection management.
 * @version: 1.0.0
 */
public final class ClientConfiguration {
    public static void main(String[] args) {
        //use custom message parse /writer to customize the way http
        //messages are paresed from and written out to the data stream
        HttpMessageParserFactory<HttpResponse> responseParserFactory = new
                DefaultHttpResponseParserFactory() {
                    @Override
                    public HttpMessageParser<HttpResponse> create(SessionInputBuffer buffer,
                                                                  MessageConstraints constraints) {

                        LineParser lineParser = new BasicLineParser() {
                            @Override
                            public Header parseHeader(CharArrayBuffer buffer) {
                                try {
                                    return super.parseHeader(buffer);
                                } catch (ParseException e) {
                                    return new BasicHeader(buffer.toString(), null);
                                }
                            }
                        };

                        return new DefaultHttpResponseParser(buffer, lineParser,
                                DefaultHttpResponseFactory.INSTANCE, constraints);
                    }
                };

        HttpMessageWriterFactory<HttpRequest> requestWriterFactory = new DefaultHttpRequestWriterFactory();
        //use a custom connection factory to customize the process of initialization of outgoing http
        // connections. Beside standard connection configuration parameters http connection factory can
        //define message parer /writer routines to be employed by individual connections.

//        HttpConnectionFactory<HttpRoute,ManagedHttpClientConnection> connFactory =
        ManagedHttpClientConnectionFactory connFactory = new ManagedHttpClientConnectionFactory(requestWriterFactory, responseParserFactory);
    }
}
/*
 * ====================================================================
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 */

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import util.HttpClientUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QuickStart {

    public static void main(String[] args) throws Exception {
        clientAsk();
//        clientWithRespHandler();
    }

    private static void clientAsk() throws IOException {
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet("http://httpbin.org/get");
            CloseableHttpResponse response1 = httpclient.execute(httpGet);
            // The underlying HTTP connection is still held by the response object
            // to allow the response content to be streamed directly from the network socket.
            // In order to ensure correct deallocation of system resources
            // the user MUST call CloseableHttpResponse#close() from a finally clause.
            // Please note that if response content is not fully consumed the underlying
            // connection cannot be safely re-used and will be shut down and discarded
            // by the connection manager.
            printResp(response1);

            HttpPost httpPost = new HttpPost("http://httpbin.org/post");
            List<NameValuePair> nvps = new ArrayList<>();
            nvps.add(new BasicNameValuePair("username", "vip"));
            nvps.add(new BasicNameValuePair("password", "secret"));
            httpPost.setEntity(new UrlEncodedFormEntity(nvps));
            CloseableHttpResponse response2 = httpclient.execute(httpPost);

            printResp(response2);
        }
    }

    public static void getWeather() {
        HttpClient httpClient = HttpClientUtils.buildHttpClient();
        HttpPost httpPost = new HttpPost("");
        try {
            httpClient.execute(httpPost);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void requestAsk() {
        // The fluent API relieves the user from having to deal with manual deallocation of system
        // resources at the cost of having to buffer response content in memory in some cases.


    }

    /**
     * This example demonstrates how to process HTTP responses using a response handler. This is the recommended way of executing HTTP requests and processing HTTP responses.
     * This approach enables the caller to concentrate on the process of digesting HTTP responses and to delegate the task of system resource deallocation to HttpClient.
     * The use of an HTTP response handler guarantees that the underlying HTTP connection will be released back to the connection manager automatically in all cases.
     *
     * @throws IOException
     */
    public static void clientWithRespHandler() throws IOException {
        try (CloseableHttpClient httpClient = HttpClientUtils.buildHttpClient()) {
            HttpGet httpGet = new HttpGet("https://www.baidu.com/");

            ResponseHandler<String> responseHandler = httpResponse -> {
                int statusCode = httpResponse.getStatusLine().getStatusCode();
                if (statusCode >= 200 && statusCode < 300) {
                    HttpEntity entity = httpResponse.getEntity();
                    return entity != null ? EntityUtils.toString(entity) : null;
                } else {
                    throw new ClientProtocolException("unexcepted response: " + statusCode);
                }
            };
            String responseBody = httpClient.execute(httpGet, responseHandler);
            System.out.println("----------------------------");
            System.out.println(responseBody);
        }
    }


    private static void printResp(CloseableHttpResponse response2) throws IOException {
        try {
            System.out.println(response2.getStatusLine());
            HttpEntity entity2 = response2.getEntity();
            // do something useful with the response body
            // and ensure it is fully consumed
            EntityUtils.consume(entity2);
        } finally {
            response2.close();
        }
    }

}
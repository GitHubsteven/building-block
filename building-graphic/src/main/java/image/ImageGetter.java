package image;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2022/6/8
 * @description
 * @copyright COPYRIGHT © 2014 - 2021/5/18 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class ImageGetter {
    static String img_url = "https://fr.louisvuitton.com/images/is/image/lv/1/PP_VP_L/louis-vuitton-sac-petite-bo%C3%AEte-chapeau-cuir-de-crocodile-brillant-sacs-%C3%A0-main--N96253_PM2_Front%20view.jpg";

    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url(img_url)
                .method("GET", null)
                .addHeader("Accept-Encoding","gzip, deflate, br")
                .addHeader("User-Agent","PostmanRuntime/7.28.4")
//                .addHeader("Cookie", "ak_cc=CN")
                .build();
        Response response = client.newCall(request).execute();
        assert response.body() != null;
        InputStream inputStream = response.body().byteStream();
        System.out.println(StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8));
    }
}

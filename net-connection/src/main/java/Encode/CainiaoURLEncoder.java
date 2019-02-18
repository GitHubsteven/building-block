package Encode;

import com.google.common.base.Charsets;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;

/**
 * Java 的 URLEncoder 会将空格转换为"+"。这不是标准行为，同时也是菜鸟不接受的内容。
 * 菜鸟文档明确要求处理该转换。所以，这里需要自行转换 + 为 %20
 * Created by jonas on 2017/4/27.
 */
final class CainiaoURLEncoder {
    static String urlEncode(String content) {
        return urlEncode(content, Charsets.UTF_8);
    }

    private static String urlEncode(String content, Charset charset) {
        try {
            return URLEncoder.encode(content, charset.name()).replaceAll("\\+", "%20");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}

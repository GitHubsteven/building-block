package Encode;

import org.apache.commons.io.Charsets;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 10:58 2019/2/15.
 */
public class EnAndDecode {
    public static void main(String[] args) {
        String context = "name=ja ck.陈&age=12";
        String encodeContext;
        //加密
        try {
            encodeContext = URLEncoder.encode(context, Charsets.UTF_8.name());
            System.out.println("encode context: " + encodeContext);
            String cnEncode = CainiaoURLEncoder.urlEncode(context);
            System.out.println("cainiao url encode:" + cnEncode);
            String decodeContext = URLDecoder.decode(encodeContext, "UTF-8");
            String cndecode = URLDecoder.decode(cnEncode, "UTF-8");
            System.out.println("decode context: " + decodeContext);
            System.out.println("cn decode context: " + cndecode);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
}
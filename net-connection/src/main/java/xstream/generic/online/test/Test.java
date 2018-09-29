package xstream.generic.online.test;

import com.thoughtworks.xstream.XStream;

/**
 * @author: jet.xie
 * @Date: 2018/9/26
 * @Description:
 * @version: 1.0.0
 */
public class Test {
    public static void main(String[] args) {
        String xml = "<RESPONSE><ERRORINFO></ERRORINFO><RETINFO><FRUITS><FRUIT><Name>apple</Name></FRUIT><FRUIT><Name>banana</Name></FRUIT></FRUITS></RETINFO></RESPONSE>";

        XStream xstream = new XStream();
        xstream.processAnnotations(new Class[]{Response.class, RetInfo_FRUITS.class});
        xstream.autodetectAnnotations(true);
        Response<RetInfo_FRUITS> resp = (Response<RetInfo_FRUITS>) xstream.fromXML(xml);
        System.out.println(resp.toString());

    }


}
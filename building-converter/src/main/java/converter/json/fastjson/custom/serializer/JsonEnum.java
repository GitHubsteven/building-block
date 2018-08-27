package converter.json.fastjson.custom.serializer;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/8/25
 * @Time: 18:53
 * @Description:
 * @version: 1.0.0
 */
public class JsonEnum {
    public static enum OrderActionEnum {
        FAIL(1), SUCC(0);

        private int code;

        OrderActionEnum(int code) {
            this.code = code;
        }
    }
}
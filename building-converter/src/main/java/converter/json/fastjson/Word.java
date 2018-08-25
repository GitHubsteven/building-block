package converter.json.fastjson;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/8/25
 * @Time: 18:11
 * @Description:
 * @version: 1.0.0
 */
@Data
public class Word {
    @JSONField(name = "A" ,ordinal = 5)
    private String a;
    private Integer b;
    private Boolean c;
    private String d;
    @JSONField(serialize = false)
    private String e;
    private String f;
    @JSONField(name = "now", format = "yyyy-MM-dd HH:mm:ss")
    private Date date;
}
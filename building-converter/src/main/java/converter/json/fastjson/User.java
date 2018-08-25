package converter.json.fastjson;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/8/25
 * @Time: 17:39
 * @Description:
 * @version: 1.0.0
 */
@Data
public class User {
    private String name;
    private Integer age;
    private BigDecimal salary;
}
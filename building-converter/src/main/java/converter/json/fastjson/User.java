package converter.json.fastjson;

import bean.Person;
import lombok.Getter;
import lombok.Setter;

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
@Setter
@Getter
public class User extends Person {
    private BigDecimal salary;
}
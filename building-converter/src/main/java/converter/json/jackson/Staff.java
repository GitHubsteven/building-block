package converter.json.jackson;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/8/24
 * @Time: 20:22
 * @Description:
 * @version: 1.0.0
 */
@Data
@Accessors(chain = true)
public class Staff implements Serializable {
    private String name;
    private Integer age;
    private String position;
    private BigDecimal salary;
    private List<String> skills;
}
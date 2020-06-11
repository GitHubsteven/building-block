package converter.json.jackson;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/6/11
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Data
@Accessors(chain = true)
public class Worker implements Serializable {
    private String name;
    private Integer age;
    private String position;
    private BigDecimal salary;
    private List<String> skills;
}
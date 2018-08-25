package converter.json.jackson;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/8/24
 * @Time: 20:52
 * @Description:
 * @version: 1.0.0
 */
@Data
public class StaffOne {
    @JsonView(Views.Normal.class)
    private String name;

    @JsonView(Views.Normal.class)
    private int age;

    @JsonView(Views.Normal.class)
    private String position;

    @JsonView(Views.Manager.class)
    private BigDecimal salary;

    @JsonView(Views.Normal.class)
    private List<String> skills;
}
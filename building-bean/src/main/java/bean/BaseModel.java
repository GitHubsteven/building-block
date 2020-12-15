package bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/6/8
 * @Time: 17:43
 * @Description:
 * @version: 1.0.0
 */
@Setter
@Getter
@ToString
public class BaseModel {
    private Long id;
    private Date modified;
    private String modifier;
    private String creator;


    public void superMethod1(BaseModel model) {

    }

    public void superModel2(List<? extends BaseModel> list) {

    }

}
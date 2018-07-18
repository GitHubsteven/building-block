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
public class BaseModel {
    private String name = "BaseModel";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void contain1() {
        System.out.println(this.name);
        System.out.println(this.getName());
        System.out.println("=============name contains 1 ?" + name.contains("1"));
    }

    public void superMethod1(BaseModel model) {

    }

    public void superModel2(List<? extends BaseModel> list) {

    }

}
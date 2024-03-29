package bean;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/7/2
 * @Time: 19:20
 * @Description:
 * @version: 1.0.0
 */
public class SubModel1 extends BaseModel {
    private String name = "bean.SubModel1";
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void self() {
        System.out.println("name: " + name);
    }

    @Override
    public void superMethod1(BaseModel model) {
        super.superMethod1(model);
    }

    @Override
    public void superModel2(List<? extends BaseModel> list) {
        super.superModel2(list);
    }
}
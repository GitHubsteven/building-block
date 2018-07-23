package practice;

import bean.BaseModel;
import bean.SubModel1;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/7/20
 * @Time: 20:38
 * @Description:
 * @version: 1.0.0
 */
public class InheritClass {
    public static void main(String[] args) {
        SubModel1 subModel = new SubModel1();
        subModel.setAge(10);
        subModel.setName("child");

        intruduce(subModel);
    }

    private static <T extends BaseModel> void intruduce(T baseModel) {
        System.out.println(baseModel.toString());
    }

}
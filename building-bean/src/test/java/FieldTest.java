import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/7/2
 * @Time: 19:22
 * @Description:
 * @version: 1.0.0
 */
public class FieldTest<T extends BaseModel> {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();
        System.out.println(strings.getClass().getSimpleName());
        System.out.println(strings.getClass().getSimpleName());
        System.out.println(integers.getClass() == integers.getClass());
    }

    public static void generic(List<? super SubModel1> t) {
        System.out.println("paragram class : " + t.get(0).getClass().getSimpleName());
    }


    public static <E> void generice2(E ele) {
        List<? super SubModel2> superList = new ArrayList<>();
        List<? extends SubModel2> extendList = new ArrayList<>();

        BaseModel baseModel = new BaseModel();
        SubModel2 subModel2 = new SubModel2();

//        generic6(extendList);
    }

    public static <E> void generic3(E ele) {

    }

    public static void generic4(BaseModel model) {

    }

    public static void generic6(List<? extends BaseModel> models, Class<? extends BaseModel> clz)
    {
    }


//    public static void generic5(List<Integer> params) {
//
//    }

    public static void generic5(List<? extends Number> params) {

    }
}
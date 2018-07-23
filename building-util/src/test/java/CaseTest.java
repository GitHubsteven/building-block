/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/7/20
 * @Time: 15:51
 * @Description:
 * @version: 1.0.0
 */
public class CaseTest {
    public static void main(String[] args) {
        run(1);
    }

    static void run(int x){
        Case.of(x)
                .when(0,()-> System.out.println("A"))
                .when(1,()-> System.out.println("B"))
                .when(2,()-> System.out.println("C"))    //这里不会被执行到，所以其实when的概念是执行不是注册，然而我们可以考虑下注册的方式。
                .orDefault(()-> System.out.println("NAN"));
    }
}
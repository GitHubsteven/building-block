package lambda.observer;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author asaland.xie
 * @Description:
 * @Date: Created at 21:32 2018/3/21.
 */
public class Aliens implements LandingObserver{
    @Override
    public void observeLanding(String name) {
        if(name.contains("appolo")){
            System.out.println("they distracted, let's invade earth!");
        }
    }
}

package lambda.observer;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @author asaland.xie
 * @description:
 * @date: Created at 21:34 2018/3/21.
 */
public class Nasa implements LandingObserver {
    @Override
    public void observeLanding(String name) {
        if (name.contains("appolo")) {
            System.out.println("we make it!");
        }
    }
}

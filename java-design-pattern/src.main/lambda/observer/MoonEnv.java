package lambda.observer;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author asaland.xie
 * @Description:
 * @Date: Created at 21:36 2018/3/21.
 */
public class MoonEnv {
    public static void main(String[] args) {
        lambda();
    }

    private static void traditional() {
        Moon moon = new Moon();
        moon.addObserver(new Aliens());
        moon.addObserver(new Nasa());

        moon.land("some one");
        moon.land("appolo");
    }

    private static void lambda() {
        Moon moon = new Moon();
        moon.addObserver((name -> {
            if(name.contains("apoolo")){
                System.out.println("NASA: we make it");
            }
        }));

        moon.addObserver(name -> {

            if(name.contains("apoolo")){
                System.out.println("Aliens: attack!");
            }
        });

        moon.land("some one");
        moon.land("apoolo");
    }

}

package tranditional.strategy;

public class LiverpoolClubStrategy implements IClubIntroStrategy {

    @Override
    public void name() {
        System.out.println("Liverpool FC");
    }

    @Override
    public void age() {
        System.out.println(120);
    }

    @Override
    public void city() {
        System.out.println("Liverpool");
    }
}

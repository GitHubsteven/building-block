package tranditional.strategy;

public class MCClubStrategy implements IClubIntroStrategy {
    @Override
    public void name() {
        System.out.println("Manchester City FC");
    }

    @Override
    public void age() {
        System.out.println(98);
    }

    @Override
    public void city() {
        System.out.println("Manchester");
    }
}

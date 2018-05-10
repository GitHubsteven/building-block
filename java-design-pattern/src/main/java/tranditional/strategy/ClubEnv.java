package tranditional.strategy;

/**
 * introduce club
 *
 * Created by rongbin.xie on 2018/3/21.
 */
public class ClubEnv {
    public static void main(String[] args) {
        traStrategy();
    }

    private static void traStrategy() {
        IClubIntroStrategy strategy = new MCClubStrategy();

        IntroduceClub introduceClub = new IntroduceClub(strategy);
        introduceClub.introduce();
    }

    public static void lambdaStrategy(){
        IntroduceClub introduceClub = new IntroduceClub(LiverpoolClubStrategy::new);   //functionInterface is in need
        introduceClub.introduce();
    }
}

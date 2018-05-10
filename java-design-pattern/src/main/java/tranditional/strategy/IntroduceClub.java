package tranditional.strategy;

/**
 * Introduce Club
 *
 * Created by rongbin.xie on 2018/3/21.
 */
public class IntroduceClub {
    private IClubIntroStrategy clubIntroStrategy;

    public IntroduceClub(IClubIntroStrategy clubIntroStrategy) {
        this.clubIntroStrategy = clubIntroStrategy;
    }

    void introduce(){
        this.clubIntroStrategy.name();
//        this.clubIntroStrategy.age();
//        this.clubIntroStrategy.city();
    }
}

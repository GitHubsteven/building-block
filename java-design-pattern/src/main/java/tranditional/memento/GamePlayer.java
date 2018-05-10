package tranditional.memento;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author rongbin.xie
 * @Description:
 * @Date: Created at 13:06 2018/5/10.
 */
public class GamePlayer {
    private Integer bloodFlow;
    private Integer magicFlow;
    private Integer level;
    private String scene;

    public Integer getBloodFlow() {
        return bloodFlow;
    }

    public void setBloodFlow(Integer bloodFlow) {
        this.bloodFlow = bloodFlow;
    }

    public Integer getMagicFlow() {
        return magicFlow;
    }

    public void setMagicFlow(Integer magicFlow) {
        this.magicFlow = magicFlow;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getScene() {
        return scene;
    }

    public void setScene(String scene) {
        this.scene = scene;
    }
}

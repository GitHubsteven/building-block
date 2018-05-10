package tranditional.memento;

import lombok.Data;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author rongbin.xie
 * @Description:
 * @Date: Created at 13:06 2018/5/10.
 */
@Data
public class GamePlayer {
    private Integer bloodFlow;
    private Integer magicFlow;
    private Integer level;
    private String scene;

    public void revert(Memento memento) {
        this.bloodFlow = memento.getBloodFlow();
        this.magicFlow = memento.getMagicFlow();
        this.level = memento.getLevel();
        this.scene = memento.getScene();
    }

    public Memento memento() {
        Memento memento = new Memento();
        memento.setScene(scene);
        memento.setLevel(level);
        memento.setMagicFlow(magicFlow);
        memento.setBloodFlow(bloodFlow);
        return memento;
    }

    @Override
    public String toString() {
        return "GamePlayer{" +
                "bloodFlow=" + bloodFlow +
                ", magicFlow=" + magicFlow +
                ", level=" + level +
                ", scene='" + scene + '\'' +
                '}';
    }

}

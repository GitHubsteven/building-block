package tranditional.command.indiv.kingdom.role;

/**
 * killer2, one of killers
 * <p>
 * Created by rongbin.xie on 2018/3/21.
 */
public class Killer implements IKiller {
    private String name;

    public Killer(String name) {
        this.name = name;
    }

    /**
     * kill is free, will reject task if not.
     *
     * @return kill is available
     */
    @Override
    public boolean isFree() {
        return true;
    }

    /**
     * conduct the kill tranditional.command.
     */
    @Override
    public void kill() {
        System.out.println(name + " is conducting kill tranditional.command!");
    }
}

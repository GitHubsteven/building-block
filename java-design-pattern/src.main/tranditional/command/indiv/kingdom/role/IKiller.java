package tranditional.command.indiv.kingdom.role;

/**
 * killer role.
 *
 * Created by rongbin.xie on 2018/3/21.
 */
public interface IKiller {
    /**
     * kill is free, will reject task if not.
     *
     * @return kill is available
     */
    boolean isFree();

    /**
     * conduct the kill tranditional.command.
     */
    void kill();
}

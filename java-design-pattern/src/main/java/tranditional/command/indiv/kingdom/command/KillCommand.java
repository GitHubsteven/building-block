package tranditional.command.indiv.kingdom.command;

import tranditional.command.indiv.kingdom.role.IKiller;

/**
 * kill tranditional.command
 *
 * Created by rongbin.xie on 2018/3/21.
 */
public class KillCommand implements ICommand {
    private IKiller killer;

    public KillCommand(IKiller killer){
        this.killer = killer;
    }

    @Override
    public void operate() {
        this.kill();
    }

    private void kill(){
        if(killer.isFree()){
            killer.kill();
        }else{
            System.out.println("kill is not free!");
        }
    }
}

package tranditional.command.indiv.kingdom;

import tranditional.command.indiv.kingdom.command.ICommand;
import tranditional.command.indiv.kingdom.command.KillCommand;
import tranditional.command.indiv.kingdom.role.Killer;

/**
 * kill environment
 *
 * Created by rongbin.xie on 2018/3/21.
 */
public class KillEnv {
    public static void main(String[] args) {
        Killer kalle = new Killer("kalle");
        ICommand killCommand = new KillCommand(kalle);
        King king = new King();
        king.setCommand(killCommand);

        king.sendCommand();

    }
}

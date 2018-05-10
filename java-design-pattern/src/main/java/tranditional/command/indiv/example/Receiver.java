package tranditional.command.indiv.example;

import tranditional.bean.business.JavaDevDirEnum;

/**
 * 命令接收者，和命令、命令者（invoker）没有任何关系。
 */
public class Receiver {
    private JavaDevDirEnum.COMMAND_ROLE commandRole;

    public Receiver(JavaDevDirEnum.COMMAND_ROLE commandRole) {
        this.commandRole = commandRole;
    }

    public void action() {
        System.out.println("receiver " + commandRole.name() + " is in sendCommand ...");
    }
}

package tranditional.command.indiv.kingdom;

import tranditional.command.indiv.kingdom.command.ICommand;

/**
 * king is invoker
 * <p>
 * Created by rongbin.xie on 2018/3/21.
 */
public class King {
    private ICommand command;

    void sendCommand() {
        enableSendCommand();
        command.operate();
    }

    private void enableSendCommand() {
        if (command == null) throw new RuntimeException("tranditional.command can not be null!");
    }

    public ICommand getCommand() {
        return command;
    }

    public King setCommand(ICommand command) {
        this.command = command;
        return this;
    }
}


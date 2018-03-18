package command.indiv.example;

import bean.business.JavaDevDirEnum;

public class Environment {
    public static void main(String[] args) {
        Receiver receiver1 = new Receiver(JavaDevDirEnum.COMMAND_ROLE.SOLDIER_ONE);
        Command command1 = new MyCommand(receiver1);
        Invoker invoker = new Invoker(command1);
        invoker.sendCommand();
    }
}

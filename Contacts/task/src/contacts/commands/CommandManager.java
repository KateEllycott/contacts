package contacts.commands;

public class CommandManager {

    private Command command;

    public void setCommand(Command command) {

        this.command = command;
    }

    public void executeCommand() {
        command.execute();
    }
}

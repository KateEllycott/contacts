import java.util.Scanner;

class Client {

    public static void main(String[] args) {

        Controller controller = new Controller();
        TV tv = new TV();


        Command changeChannel;
        int[] channelList = new int[3];

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            channelList[i] = scanner.nextInt();
        }

        Command turnOnTV = new TurnOnCommand(tv);
        controller.setCommand(turnOnTV);
        controller.executeCommand();

        for (int i = 0; i < 3; i++) {
        Channel channel = new Channel(channelList[i]);
        changeChannel = new ChangeChannelCommand(channel);
        controller.setCommand(changeChannel);
        controller.executeCommand();
        }

        Command turnOffTV = new TurnOffCommand(tv);
        controller.setCommand(turnOffTV);
        controller.executeCommand();
    }
}

class TV {

    void turnOn() {
        System.out.println("Turning on the TV");
    }

    void turnOff() { System.out.println("Turning off the TV");}
}

class Channel {
    private int channelNumber;

    Channel(int channelNumber) {
        this.channelNumber = channelNumber;
    }

    void changeChannel() {
        System.out.println("Channel was changed to " + channelNumber);
    }

}

interface Command {
    public void execute();
}

class TurnOnCommand implements Command {
    private  TV tv;

    TurnOnCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.turnOn();
    }
}

class TurnOffCommand implements Command {
    private  TV tv;

    TurnOffCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.turnOff();
    }
}

class ChangeChannelCommand implements Command {
    private Channel channel;

    ChangeChannelCommand(Channel channel) {
        this.channel = channel;
    }

    @Override
    public void execute() {
        channel.changeChannel();
    }
}

class Controller {
    private Command command;
    void setCommand(Command command) {
        this.command = command;
    }
    void executeCommand() {
        command.execute();
    }
}
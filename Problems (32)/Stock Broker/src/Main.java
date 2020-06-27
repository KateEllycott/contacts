public class Main {

    public static void main(String[] args) {

        Stock stock = new Stock();
        BuyCommand buy = new BuyCommand(stock);
        SellCommand sell = new SellCommand(stock);
        Broker broker = new Broker();

        broker.setCommand(buy);
        broker.executeCommand();

        broker.setCommand(sell);
        broker.executeCommand();
    }
}


class Stock {

    public void buy() {
        System.out.println("Stock was bought");
    }

    public void sell() {
        System.out.println("Stock was sold");
    }
}

interface Command {

    public void execute();
}

class BuyCommand implements Command {
    private Stock stock;

    public BuyCommand(Stock stock) {
        this.stock = stock;
    }

    public void execute() {
        stock.buy();
    }
}

class SellCommand implements Command {
    private Stock stock;

    public SellCommand(Stock stock) {
        this.stock = stock;
    }

    public void execute() {
        stock.sell();
    }
}

class Broker {
    private Command command;
    public void setCommand(Command command) {
        this.command = command;
    }
    public void executeCommand() {
       command.execute();
    }
}
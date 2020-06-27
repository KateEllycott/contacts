interface Movable {
    int getX();
    int getY();
    void setX(int newX);
    void setY(int newY);
}

interface Storable {
    int getInventoryLength();
    String getInventoryItem(int index);
    void setInventoryItem(int index, String item);
}

interface Command {
    void execute();
    void undo();
}

class CommandMove implements Command {
    int xMovement;
    int yMovement;

    private final Movable entity;

    public CommandMove(Movable entity) {
        this.entity = entity;
    }

    @Override
    public void execute() {
        xMovement = entity.getX();
        yMovement = entity.getY();
        entity.setX(entity.getX() + 1);
        entity.setY(entity.getY() + 1);
    }

    @Override
    public void undo() {
        entity.setX(xMovement);
        entity.setY(yMovement);
    }
}

class CommandPutItem implements Command{

    private final Storable entity;
    String item;

    public CommandPutItem(Storable entity) {
        this.entity = entity;
    }

    @Override
    public void execute() {
       //

    }

    @Override
    public void undo() {

    }


}
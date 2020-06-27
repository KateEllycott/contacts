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

    private int oldX;
    private int oldY;

    Movable entity;

    @Override
    public void execute() {
        oldX = entity.getX();
        oldY = entity.getY();
        entity.setX(xMovement);
        entity.setY(yMovement);
    }

    @Override
    public void undo() {
        entity.setX(oldX);
        entity.setY(oldY);
    }
}

class CommandPutItem implements Command {
    private int lastIndex = -1;
    private int lastItem;
    Storable entity;
    String item;

    @Override
    public void execute() {
        for(int i = 0; i < entity.getInventoryLength(); i++) {
            if(entity.getInventoryItem(i) == null) {
                entity.setInventoryItem(i, item);
                lastIndex = i;
                break;
            }
        }

    }

    @Override
    public void undo() {
        if(lastIndex >= 0) {
            entity.setInventoryItem(lastIndex, null);
        }
    }
}
package rover;

import constants.Direction;
import constants.Command;
import static processing.Processing.processPosition;

public class Rover {

    private Integer xPos;
    private Integer yPos;
    private String direction;

    public Rover(int xPos, int yPos, String direction) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.direction = direction;
    }

    public String process(String commands) {
        if(isEmpty(commands)) {
            return processPosition(xPos, yPos, direction);
        }
        for(String command: getSplit(commands)){
            if(isMove(command)){
                switch (direction) {
                    case Direction.NORTH:
                        moveNorth();
                        break;
                    case Direction.SOUTH:
                        moveSouth();
                        break;
                    case Direction.EAST:
                        moveEast();
                        break;
                    default:
                        moveWest();
                        break;
                }
            }
            else if(isRight(command)){
                turnRight(direction);
            }
        }
        return processPosition(xPos, yPos, direction);
    }

    private void turnRight(String direction) {
        switch (direction) {
            case Direction.NORTH:
                changeDirection(Direction.EAST);
                break;
            case Direction.SOUTH:
                changeDirection(Direction.WEST);
                break;
            case Direction.EAST:
                changeDirection(Direction.SOUTH);
                break;
            default:
                changeDirection(Direction.NORTH);
                break;
        }
    }

    private void changeDirection(String newDirection) {
        this.direction = newDirection;
    }

    private boolean isRight(String command) {
        return command.equals("R");
    }

    private boolean isEmpty(String commands){
        return commands.equals("");
    }

    private void moveWest() {
        xPos -= 1;
    }

    private void moveEast() {
        xPos += 1;
    }

    private void moveSouth() {
        yPos -= 1;
    }

    private void moveNorth() {
        yPos += 1;
    }

    private String[] getSplit(String commands) {
        return commands.split("");
    }

    private boolean isMove(String command){
        return command.equals(Command.MOVE);
    }

}

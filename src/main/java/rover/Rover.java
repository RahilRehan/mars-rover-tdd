package rover;

import utils.Command;
import utils.Direction;

import static utils.Command.*;
import static processing.Processing.processPosition;
import static utils.Direction.*;

public class Rover {

    private Integer xPos;
    private Integer yPos;
    private String direction;
    private static final Integer FORWARD=1;
    private static final Integer BACKWARD=-1;


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
            switch (command){
                case MOVE:
                    move(direction);
                    break;
                case RIGHT:
                    turnRight(direction);
                    break;
                default:
                    turnLeft(direction);
                    break;
            }
        }
        return processPosition(xPos, yPos, direction);
    }

    private void move(String direction) {
        switch (direction) {
            case NORTH:
                moveVertical(FORWARD);
                break;
            case SOUTH:
                moveVertical(BACKWARD);
                break;
            case EAST:
                moveHorizontal(FORWARD);
                break;
            default:
                moveHorizontal(BACKWARD);
                break;
        }
    }

    private void turnLeft(String direction) {
        switch (direction) {
            case NORTH:
                changeDirection(WEST);
                break;
            case SOUTH:
                changeDirection(EAST);
                break;
            case EAST:
                changeDirection(NORTH);
                break;
            default:
                changeDirection(SOUTH);
                break;
        }
    }

    private void turnRight(String direction) {
        switch (direction) {
            case NORTH:
                changeDirection(EAST);
                break;
            case SOUTH:
                changeDirection(WEST);
                break;
            case EAST:
                changeDirection(SOUTH);
                break;
            default:
                changeDirection(NORTH);
                break;
        }
    }

    private void changeDirection(String newDirection) {
        this.direction = newDirection;
    }

    private void moveHorizontal(Integer direction){
        xPos += direction;
    }

    private void moveVertical(Integer direction){
        yPos += direction;
    }

}

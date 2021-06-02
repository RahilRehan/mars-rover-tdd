package rover;


import exceptions.InvalidPositionException;
import plateau.Plateau;
import position.Position;

import static plateau.Plateau.checkIfValidPosition;
import static utils.Command.*;
import static utils.Direction.*;

public class Rover {

    private final Plateau plateau;
    private Position position;
    private String direction;
    private static final Integer FORWARD=1;
    private static final Integer BACKWARD=-1;


    public Rover(int xPos, int yPos, String direction, Plateau plateau) throws InvalidPositionException {
        if(xPos < 0  || xPos > plateau.getLimit().getxPos()) throw new InvalidPositionException("Horizontally wrong position");
        if(yPos < 0  || yPos > plateau.getLimit().getyPos()) throw new InvalidPositionException("Vertically wrong position");
        this.position = new Position(xPos, yPos);
        this.direction = direction;
        this.plateau = plateau;
    }

    public String process(String commands) throws InvalidPositionException {
        for(String command: getSplit(commands))
            switch (command) {
                case MOVE:
                    move(direction);
                    break;
                case RIGHT:
                    turnRight(direction);
                    break;
                case LEFT:
                    turnLeft(direction);
                    break;
                default:
                    return this.toString();
            }
        return this.toString();
    }

    private void move(String direction) throws InvalidPositionException {
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

    private void moveHorizontal(Integer direction) throws InvalidPositionException {
        position = new Position(position.getxPos()+direction, position.getyPos());
        checkIfValidPosition(position, plateau);
    }

    private void moveVertical(Integer direction) throws InvalidPositionException {
        position = new Position(position.getxPos(), position.getyPos()+direction);
        checkIfValidPosition(position, plateau);
    }


    @Override
    public String toString() {
        return this.position.toString() + " " + this.direction;
    }
}

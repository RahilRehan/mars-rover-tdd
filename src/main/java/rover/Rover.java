package rover;

import constants.Direction;
import constants.Command;
import static processing.Processing.processPosition;

public class Rover {

    private Integer xPos;
    private Integer yPos;
    private final String direction;

    public Rover(int xPos, int yPos, String direction) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.direction = direction;
    }

    public String process(String commands) {
        if(commands.equals("")) {
            return processPosition(xPos, yPos, direction);
        }
        for(String command: getSplit(commands)){
            if(isMove(command)){
                switch (direction) {
                    case Direction.NORTH:
                        yPos += 1;
                        break;
                    case Direction.SOUTH:
                        yPos -= 1;
                        break;
                    case Direction.EAST:
                        xPos += 1;
                        break;
                    default:
                        xPos -= 1;
                        break;
                }
            }
        }
        return processPosition(xPos, yPos, direction);
    }

    private String[] getSplit(String commands) {
        return commands.split("");
    }

    private boolean isMove(String command){
        return command.equals(Command.MOVE);
    }

}

package rover;

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

    public String move(String commands) {
        if(commands.equals("")) {
            return processPosition(xPos, yPos, direction);
        }
        for(String command:commands.split("")){
            if(command.equals("M")){
                switch (direction) {
                    case "N":
                        yPos += 1;
                        break;
                    case "S":
                        yPos -= 1;
                        break;
                    case "E":
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

}

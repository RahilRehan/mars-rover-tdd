package rover;

import static processing.Processing.processPosition;

public class Rover {

    private final Integer xPos;
    private final Integer yPos;
    private final String direction;

    public Rover(int xPos, int yPos, String direction) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.direction = direction;
    }

    public String move(String commands) {
        if(commands.equals("")) {
            return processPosition(this.xPos, this.yPos, this.direction);
        }
        return null;
    }

}

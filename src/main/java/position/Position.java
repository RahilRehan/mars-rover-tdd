package position;


import exceptions.InvalidPositionException;

public class Position {

    private final Integer xPos;
    private final Integer yPos;

    public Position(Integer xPos, Integer yPos) throws InvalidPositionException {
        if(xPos < 0 || yPos < 0) throw new InvalidPositionException("Negative values in constructor");
        this.xPos = xPos;
        this.yPos = yPos;
    }


    public Integer getxPos() {
        return xPos;
    }

    public Integer getyPos() {
        return yPos;
    }

    @Override
    public String toString() {
        return this.xPos + " " + this.yPos;
    }
}

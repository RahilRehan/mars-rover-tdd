package plateau;

import exceptions.InvalidPositionException;
import position.Position;

public class Plateau {

    private final Position limit;

    public Plateau(Position limit) {
        this.limit = limit;
    }

    public Position getLimit() {
        return limit;
    }

    public static void checkIfValidPosition(Position position, Plateau plateau) throws InvalidPositionException {
        if(position.getxPos() > plateau.limit.getxPos()) throw new InvalidPositionException("Rover out of bounds");
        if(position.getyPos() > plateau.limit.getyPos()) throw new InvalidPositionException("Rover out of bounds");
    }
}

package plateau;

import position.Position;
import rover.Rover;

import java.util.ArrayList;

public class Plateau {

    private Position limit;
    private ArrayList<Rover> rovers = new ArrayList<>();

    public Plateau(Position limit) {
        this.limit = limit;
    }

    public boolean addRover(Rover rover){
        return rovers.add(rover);
    }

    public Position getLimit() {
        return limit;
    }
}

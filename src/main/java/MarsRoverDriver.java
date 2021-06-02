import exceptions.InvalidPositionException;
import plateau.Plateau;
import position.Position;
import rover.Rover;

import java.util.Scanner;

public class MarsRoverDriver {
    public static void main(String[] args) throws InvalidPositionException {
        Scanner scanner = new Scanner(System.in);
        String[] plateauParams = scanner.nextLine().split(" ");
        Plateau plateau = new Plateau(new Position(Integer.parseInt(plateauParams[0]), Integer.parseInt(plateauParams[1])));
        Rover rover;
        while(scanner.hasNext()){
            String[] roverParams = scanner.nextLine().split(" ");
            String commands = scanner.nextLine();
            rover = new Rover(Integer.parseInt(roverParams[0]), Integer.parseInt(roverParams[1]), roverParams[2], plateau);
            System.out.println(rover.process(commands));
        }
    }
}

/* SAMPLE INPUT

5 5
1 2 N
LMLMLMLMM
3 3 E
MMRMMRMRRM

 */
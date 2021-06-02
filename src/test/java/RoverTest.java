import exceptions.InvalidPositionException;
import org.junit.jupiter.api.Test;
import plateau.Plateau;
import position.Position;
import rover.Rover;

import static org.junit.jupiter.api.Assertions.*;

public class RoverTest {
    Plateau plateau;
    public RoverTest() throws InvalidPositionException {
        plateau = new Plateau(new Position(5, 5));
    }

    @Test
    void shouldReturnInitialPositionWithNoCommand() throws InvalidPositionException {
        int xPos = 1, yPos = 2;
        String direction = "N", commands = "";
        Rover rover = new Rover(xPos, yPos, direction, plateau);
        String finalDirection = rover.process(commands);
        assertEquals("1 2 N", finalDirection);
    }

    @Test
    void shouldReturnNextValidPositionWithMoveCommand() throws InvalidPositionException {
        int xPos = 1, yPos = 2;
        String direction = "N", commands = "M";
        Rover rover = new Rover(xPos, yPos, direction, plateau);
        String finalDirection = rover.process(commands);
        assertEquals("1 3 N", finalDirection);
    }

    @Test
    void shouldReturnNextValidPositionWithMultipleMoveCommands() throws InvalidPositionException {
        int xPos = 1, yPos = 2;
        String direction = "E", commands = "MMM";
        Rover rover = new Rover(xPos, yPos, direction, plateau);
        String finalDirection = rover.process(commands);
        assertEquals("4 2 E", finalDirection);
    }

    @Test
    void shouldReturnValidPositionWithTurnRightCommand() throws InvalidPositionException {
        int xPos = 1, yPos = 2;
        String direction = "E", commands = "R";
        Rover rover = new Rover(xPos, yPos, direction, plateau);
        String finalDirection = rover.process(commands);
        assertEquals("1 2 S", finalDirection);
    }

    @Test
    void shouldReturnValidPositionWithMultipleTurnRightCommands() throws InvalidPositionException {
        int xPos = 1, yPos = 2;
        String direction = "E", commands = "RRR";
        Rover rover = new Rover(xPos, yPos, direction, plateau);
        String finalDirection = rover.process(commands);
        assertEquals("1 2 N", finalDirection);
    }

    @Test
    void shouldReturnValidPositionWithTurnLeftCommand() throws InvalidPositionException {
        int xPos = 1, yPos = 2;
        String direction = "E", commands = "L";
        Rover rover = new Rover(xPos, yPos, direction, plateau);
        String finalDirection = rover.process(commands);
        assertEquals("1 2 N", finalDirection);
    }

    @Test
    void shouldReturnValidPositionWithMultipleTurnLeftCommands() throws InvalidPositionException {
        int xPos = 1, yPos = 2;
        String direction = "E", commands = "LLL";
        Rover rover = new Rover(xPos, yPos, direction, plateau);
        String finalDirection = rover.process(commands);
        assertEquals("1 2 S", finalDirection);
    }

    @Test
    void shouldNotThrowExceptionIfRoverInValidBoundsOfPlateau(){
        int xPos = 1, yPos = 2;
        String direction = "E";
        assertDoesNotThrow(()->new Rover(xPos, yPos, direction, plateau));
    }

    @Test
    void shouldThrowExceptionIfRoverNotInValidBoundsOfPlateauHorizontally(){
        int xPos = 6, yPos = 2;
        String direction = "E";
        assertThrows(InvalidPositionException.class, ()->new Rover(xPos, yPos, direction, plateau));
    }

    @Test
    void shouldThrowExceptionIfRoverNotInValidBoundsOfPlateauVertically() {
        int xPos = 1, yPos = -4;
        String direction = "E";
        assertThrows(InvalidPositionException.class, ()->new Rover(xPos, yPos, direction, plateau));
    }

    @Test
    void shouldReturnValidPositionWithMultipleCommandsOne() throws InvalidPositionException {
        int xPos = 1, yPos = 2;
        String direction = "N", commands = "LMLMLMLMM";
        Rover rover = new Rover(xPos, yPos, direction, plateau);
        String finalDirection = rover.process(commands);
        assertEquals("1 3 N", finalDirection);
    }

    @Test
    void shouldReturnValidPositionWithMultipleCommandsTwo() throws InvalidPositionException {
        int xPos = 3, yPos = 3;
        String direction = "E", commands = "MMRMMRMRRM";
        Rover rover = new Rover(xPos, yPos, direction, plateau);
        String finalDirection = rover.process(commands);
        assertEquals("5 1 E", finalDirection);
    }

    @Test
    void shouldThrowExceptionIfRoverGoesOutOfBoundsOfPlateauOne() throws InvalidPositionException {
        int xPos = 4, yPos = 3;
        String direction = "E", commands = "MMRMMRMRRM";
        Rover rover = new Rover(xPos, yPos, direction, plateau);
        assertThrows(InvalidPositionException.class, ()->rover.process(commands));
    }

    @Test
    void shouldThrowExceptionIfRoverGoesOutOfBoundsOfPlateauTwo() throws InvalidPositionException {
        int xPos = 1, yPos = 0;
        String direction = "N", commands = "LMM";
        Rover rover = new Rover(xPos, yPos, direction, plateau);
        assertThrows(InvalidPositionException.class, ()->rover.process(commands));
    }
}

import org.junit.jupiter.api.Test;
import rover.Rover;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoverTest {
    @Test
    void shouldReturnInitialPositionWithNoCommand() {
        int xPos = 1, yPos = 2;
        String direction = "N", commands = "";
        Rover rover = new Rover(xPos, yPos, direction);
        String finalDirection = rover.process(commands);
        assertEquals("1 2 N", finalDirection);
    }

    @Test
    void shouldReturnNextValidPositionWithMoveCommand() {
        int xPos = 1, yPos = 2;
        String direction = "N", commands = "M";
        Rover rover = new Rover(xPos, yPos, direction);
        String finalDirection = rover.process(commands);
        assertEquals("1 3 N", finalDirection);
    }

    @Test
    void shouldReturnNextValidPositionWithMultipleMoveCommands() {
        int xPos = 1, yPos = 2;
        String direction = "E", commands = "MMM";
        Rover rover = new Rover(xPos, yPos, direction);
        String finalDirection = rover.process(commands);
        assertEquals("4 2 E", finalDirection);
    }

    @Test
    void shouldReturnValidPositionWithTurnRightCommand() {
        int xPos = 1, yPos = 2;
        String direction = "E", commands = "R";
        Rover rover = new Rover(xPos, yPos, direction);
        String finalDirection = rover.process(commands);
        assertEquals("1 2 S", finalDirection);
    }

    @Test
    void shouldReturnValidPositionWithMultipleTurnRightCommands() {
        int xPos = 1, yPos = 2;
        String direction = "E", commands = "RRR";
        Rover rover = new Rover(xPos, yPos, direction);
        String finalDirection = rover.process(commands);
        assertEquals("1 2 N", finalDirection);
    }

    @Test
    void shouldReturnValidPositionWithTurnLeftCommand() {
        int xPos = 1, yPos = 2;
        String direction = "E", commands = "L";
        Rover rover = new Rover(xPos, yPos, direction);
        String finalDirection = rover.process(commands);
        assertEquals("1 2 N", finalDirection);
    }

    @Test
    void shouldReturnValidPositionWithMultipleTurnLeftCommands() {
        int xPos = 1, yPos = 2;
        String direction = "E", commands = "LLL";
        Rover rover = new Rover(xPos, yPos, direction);
        String finalDirection = rover.process(commands);
        assertEquals("1 2 S", finalDirection);
    }
}

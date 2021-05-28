import org.junit.jupiter.api.Test;
import rover.Rover;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoverTest {
    @Test
    void shouldReturnInitialPositionOfRoverWithNoCommand() {
        int xPos=1, yPos=2;
        String direction="N";
        Rover rover = new Rover(xPos, yPos, direction);
        String finalDirection = rover.move("");
        assertEquals("1 2 N", finalDirection);
    }
}

import exceptions.InvalidPositionException;
import org.junit.jupiter.api.Test;
import position.Position;

import static org.junit.jupiter.api.Assertions.*;

public class PositionTest {
    @Test
    void shouldNotThrowExceptionForValidPosition() {
        assertDoesNotThrow(() -> new Position(4, 5));
    }

    @Test
    void shouldThrowExceptionForInvalidPosition() {
        assertThrows(InvalidPositionException.class,()-> new Position(-5, 3) );
    }
}

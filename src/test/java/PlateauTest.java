import exceptions.InvalidPositionException;
import org.junit.jupiter.api.Test;
import plateau.Plateau;
import position.Position;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlateauTest {
    @Test
    void shouldNotThrowExceptionForValidCoordinates(){
        assertDoesNotThrow(()->new Plateau(new Position(4, 5)));
    }
    @Test
    void shouldThrowExceptionForInvalidCoordinates(){
        assertThrows(InvalidPositionException.class, ()->new Plateau(new Position(-4, 5)));
    }
}

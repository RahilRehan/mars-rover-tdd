package processing;

public class Processing {
    public static String processPosition(Integer xPos, Integer yPos, String direction) {
        return String.format("%d %d %s", xPos, yPos, direction);
    }
}

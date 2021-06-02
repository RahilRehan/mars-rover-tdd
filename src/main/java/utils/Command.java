package utils;

public class Command {
    public static final String MOVE="M";
    public static final String RIGHT = "R";
    public static final String LEFT = "L";

    public static String[] getSplit(String commands) {
        return commands.split("");
    }

}

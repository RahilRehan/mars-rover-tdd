package utils;

public class Command {
    public static final String MOVE="M";

    public static boolean isMove(String command){
        return command.equals(Command.MOVE);
    }

    public static boolean isRight(String command) {
        return command.equals("R");
    }

    public static String[] getSplit(String commands) {
        return commands.split("");
    }

    public static boolean isEmpty(String commands){
        return commands.equals("");
    }

}

package src.gamrcorps.mothership;

/**
 * Created by Matthew on 11/4/2015.
 */
public class MCharacter implements MObject {
    //TODO: STUB

    public static boolean isWhitespace(char c){
        String t = String.valueOf(c);
        return " \t\n".contains(t);
    }

    public static boolean isNumeric(char c) {
        String t = String.valueOf(c);
        return "0123456789".contains(t);
    }

    public static boolean isWhitespace(String s){
        return " \t\n".contains(s.substring(0,1));
    }

    public static boolean isNumeric(String s) {
        return "0123456789".contains(s.substring(0,1));
    }
}

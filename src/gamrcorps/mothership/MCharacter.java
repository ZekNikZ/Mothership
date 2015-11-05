package src.gamrcorps.mothership;

public class MCharacter extends MObject {
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

    public String toString() {
        return null;//TODO: FIX
    }

    public String getType() {
        return "Character";
    }
}

package src.gamrcorps.mothership;

/**
 * Created by Matthew on 11/5/2015.
 */
public class MString extends MObject {
    public String value;

    public MString(String str){
        value = str;
    }

    public String toString() {
        return value;
    }

    public String getType() {
        return "String";
    }
}

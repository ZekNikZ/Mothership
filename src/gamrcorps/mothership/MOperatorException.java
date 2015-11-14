package src.gamrcorps.mothership;

public class MOperatorException extends RuntimeException {
    public MOperatorException (String opName) {
        super("Duplicate Operator: " + opName);
    }

    public MOperatorException (String opName, MObject arg1, MObject arg2) {
        super("Undefined Operator: " + opName + " [" + arg1.getType() + "] [" + arg2.getType() + "]");
    }

    public MOperatorException (String opName, MObject arg1) {
        super("Undefined Operator: " + opName + " [" + arg1.getType() + "]");
    }
}

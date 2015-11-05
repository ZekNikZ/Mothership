package src.gamrcorps.mothership;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class MOps {
    private static Map<String, IOperator> operatorMap;

    static {
        operatorMap = new HashMap<>();
        add("+", new MOp("+") {
            @Override
            public MObject run(MStack stack) {
                MObject arg2 = stack.pop();
                MObject arg1 = stack.pop();
                if (arg1 instanceof MNumber && arg2 instanceof MNumber){
                    MNumber result = new MNumber(new BigDecimal(((MNumber) arg1).toString()).add(((MNumber) arg2).toBigDecimal()));
                    stack.push(result);
                    return result;
                } else {
                    throw new MOperatorException("+", arg1, arg2);
                }
            }
        });
    }

    public static boolean isOperator(String name) {
        return operatorMap.containsKey(name);
    }

    public static MObject runOperator(String name, MStack stack) {
        return operatorMap.get(name).run(stack);
    }

    public static void add (String name, IOperator op) {
        if (!isOperator(name)) {
            operatorMap.put(name, op);
        } else {
            throw new MOperatorException(name);
        }
    }
}
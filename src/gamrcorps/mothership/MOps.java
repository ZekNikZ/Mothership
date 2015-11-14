package src.gamrcorps.mothership;

import java.math.BigDecimal;
import java.util.DoubleSummaryStatistics;
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
        add("-", new MOp("-") {
            @Override
            public MObject run(MStack stack) {
                MObject arg2 = stack.pop();
                MObject arg1 = stack.pop();
                if (arg1 instanceof MNumber && arg2 instanceof MNumber){
                    MNumber result = new MNumber(new BigDecimal(((MNumber) arg1).toString()).subtract(((MNumber) arg2).toBigDecimal()));
                    stack.push(result);
                    return result;
                } else {
                    throw new MOperatorException("-", arg1, arg2);
                }
            }
        });
        add("*", new MOp("*") {
            @Override
            public MObject run(MStack stack) {
                MObject arg2 = stack.pop();
                MObject arg1 = stack.pop();
                if (arg1 instanceof MNumber && arg2 instanceof MNumber){
                    MNumber result = new MNumber(new BigDecimal(((MNumber) arg1).toString()).multiply(((MNumber) arg2).toBigDecimal()));
                    stack.push(result);
                    return result;
                } else {
                    throw new MOperatorException("*", arg1, arg2);
                }
            }
        });
        add("/", new MOp("/") {
            @Override
            public MObject run(MStack stack) {
                MObject arg2 = stack.pop();
                MObject arg1 = stack.pop();
                if (arg1 instanceof MNumber && arg2 instanceof MNumber){
                    MNumber result = new MNumber(new BigDecimal(((MNumber) arg1).toString()).divide(((MNumber) arg2).toBigDecimal()));
                    stack.push(result);
                    return result;
                } else {
                    throw new MOperatorException("/", arg1, arg2);
                }
            }
        });
        add("ta", new MOp() {
            @Override
            public MObject run(MStack stack) {
                MObject arg2 = stack.pop();
                MObject arg1 = stack.pop();
                if (arg1 instanceof MNumber && arg2 instanceof MNumber){
                    MNumber result = new MNumber(new BigDecimal(((MNumber) arg1).toString()).multiply(((MNumber) arg2).toBigDecimal()).divide(new MNumber(2.0).toBigDecimal()));
                    stack.push(result);
                    return result;
                } else {
                    throw new MOperatorException("ta", arg1, arg2);
                }
            }
        });
        add("tA", new MOp() {
            @Override
            public MObject run(MStack stack) {
                MObject arg2 = stack.pop();
                MObject arg1 = stack.pop();
                if (arg1 instanceof MNumber && arg2 instanceof MNumber){
                    MNumber result = new MNumber(Math.atan2(Double.parseDouble(arg1.toString()), Double.parseDouble(arg2.toString())));
                    stack.push(result);
                    return result;
                } else {
                    throw new MOperatorException("tA", arg1, arg2);
                }
            }
        });
        add("tc", new MOp() {
            @Override
            public MObject run(MStack stack) {
                MObject arg1 = stack.pop();
                if (arg1 instanceof MNumber){
                    MNumber result = new MNumber(Math.cos(Double.parseDouble(arg1.toString())));
                    stack.push(result);
                    return result;
                } else {
                    throw new MOperatorException("tc", arg1);
                }
            }
        });
        add("ts", new MOp() {
            @Override
            public MObject run(MStack stack) {
                MObject arg1 = stack.pop();
                if (arg1 instanceof MNumber){
                    MNumber result = new MNumber(Math.sin(Double.parseDouble(arg1.toString())));
                    stack.push(result);
                    return result;
                } else {
                    throw new MOperatorException("ts", arg1);
                }
            }
        });
        add("tt", new MOp() {
            @Override
            public MObject run(MStack stack) {
                MObject arg1 = stack.pop();
                if (arg1 instanceof MNumber){
                    MNumber result = new MNumber(Math.tan(Double.parseDouble(arg1.toString())));
                    stack.push(result);
                    return result;
                } else {
                    throw new MOperatorException("tt", arg1);
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
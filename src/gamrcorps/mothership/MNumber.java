package src.gamrcorps.mothership;

import java.math.BigDecimal;
import java.math.BigInteger;

//Number class to merge four data types into one

public class MNumber implements MObject {
    public long intValue;
    public double doubleValue;
    public BigInteger bigIntValue;
    public BigDecimal bigDoubleValue;
    public int type = 0;
    public static final MNumber[] numericList = new MNumber[]{zero(), new MNumber(1), new MNumber(2), new MNumber(3), new MNumber(4), new MNumber(5), new MNumber(6), new MNumber(7), new MNumber(8), new MNumber(9)};

    public MNumber(int value) {
        intValue = value;
    }

    public MNumber(long value) {
        intValue = value;
    }

    public MNumber(double value) {
        doubleValue = value;
        type = 1;
    }

    public MNumber(BigInteger value) {
        bigIntValue = value;
        type = 2;
    }

    public MNumber(BigDecimal value) {
        bigDoubleValue = value;
        type = 3;
    }

    public MNumber(String value) {
        try {
            bigIntValue = new BigInteger(value);
            type = 2;
            if (bigIntValue.bitLength() < 64) {
                intValue = Long.valueOf(bigIntValue.longValue());
                type = 0;
            }
        } catch (NumberFormatException e) {
            bigDoubleValue = new BigDecimal(value);
            type = 3;
        }
    }

    //Return a new MNumber with int value of zero (primarily for use with the stack)
    public static MNumber zero() {
        return new MNumber(0);
    }

    public MNumber add(MNumber num) {
        switch (type) {
            case 0:
                intValue += num.intValue;
            case 1:
                doubleValue += num.doubleValue;
            case 2:
                bigIntValue = bigIntValue.add(num.bigIntValue);
            case 3:
                bigDoubleValue = bigDoubleValue.add(num.bigDoubleValue);
        }
        return this;
    }

    public MNumber multiply(MNumber num) {
        switch (type) {
            case 0:
                intValue *= num.intValue;
            case 1:
                doubleValue *= num.doubleValue;
            case 2:
                bigIntValue = bigIntValue.multiply(num.bigIntValue);
            case 3:
                bigDoubleValue = bigDoubleValue.multiply(num.bigDoubleValue);
        }
        return this;
    }

    public String asString() {
        String num = "";
        switch (type) {
            case 0:
                num = "" + intValue;
            case 1:
                num = "" + doubleValue;
            case 2:
                num = bigIntValue.toString();
            case 3:
                num = bigDoubleValue.toString();
        }
        return num;
    }

    public static boolean isNumeric(char s) {
        String t = String.valueOf(s);
        return "0123456789".contains(t);
    }

    public String toString() {
        switch (type) {
            case 0:
                return "" + intValue;
            case 1:
                return "" + doubleValue;
            case 2:
                return bigIntValue.toString();
            case 3:
                return bigDoubleValue.toString();
        }
        return null;
    }
}
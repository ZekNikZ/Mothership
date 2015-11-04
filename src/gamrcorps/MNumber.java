package src.gamrcorps;

import java.math.BigDecimal;
import java.math.BigInteger;

//Number class to merge four data types into one

public class MNumber {
    public long intValue;
    public double doubleValue;
    public BigInteger bigIntValue;
    public BigDecimal bigDoubleValue;

    public MNumber (int value) {
        intValue = value;
    }

    public MNumber (long value) {
        intValue = value;
    }

    public MNumber (double value) {
        doubleValue = value;
    }

    public MNumber (BigInteger value) {
        bigIntValue = value;
    }

    public MNumber (BigDecimal value) {
        bigDoubleValue = value;
    }

    public static MNumber zero() {
        return new MNumber(0);
    }
}

package bootcamp.calculator;

import bootcamp.data.Params;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculator {
    public BigDecimal calculate(final Params params) {

        BigDecimal result = null;
        BigDecimal x = params.getX();
        BigDecimal y = params.getY();
        String op = params.getOperator();

        switch(op) {
            case "+":
                result = x.add(y);
                break;
            case "x":
                result = x.multiply(y);
                break;
            case "-":
                result = x.subtract(y);
                break;
            case "/":
                if(!y.equals(0)) {
                    result = x.divide(y);
                } else {
                    throw new IllegalStateException("do not divide by zero");
                }
                break;
            default:
                throw new IllegalArgumentException("Unexpected value: " + params.getOperator());
        }
        return result.setScale(2, RoundingMode.HALF_DOWN).stripTrailingZeros();
    }
}

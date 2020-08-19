package bootcamp.app;

import bootcamp.calculator.Calculator;
import bootcamp.data.Params;

import java.math.BigDecimal;


public class CalculatorApp {
    public static void main(final String[] args) {
        Calculator calculator = new Calculator();
        Params params = new Params(new BigDecimal(args[0]), new BigDecimal(args[2]), args[1]);
        printResult(args, calculator.calculate(params));
    }

    private static void printResult(String[] args, BigDecimal result){
        System.out.println(args[0] + " " + args[1] + " " + args[2] + " = " + result);
    }
}

package bootcamp.app;

import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.process.calculator.Calculator;
import bootcamp.process.element.impl.ElementFactoryImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.MessageFormat;

public class CalculatorApp {
    public static void main(String[] args) {
        ElementFactoryImpl factory = new ElementFactoryImpl();
        BigDecimal x, y;
        String operator;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Enter a first number:");
            x = new BigDecimal(reader.readLine());
            System.out.println("Enter a second number:");
            y = new BigDecimal(reader.readLine());
            System.out.println("Enter the operator:");
            operator = reader.readLine();
            Params params = new Params(x, y, operator);
            Calculator calculator = new Calculator(factory);
            Result result = calculator.calculate(params);
            System.out.println(result.getStatus());
            System.out.println(result.getStatusMessage());
            System.out.println(result.getValue().get());

        } catch (IOException exception) {
            System.out.println(exception);
        }
    }
}

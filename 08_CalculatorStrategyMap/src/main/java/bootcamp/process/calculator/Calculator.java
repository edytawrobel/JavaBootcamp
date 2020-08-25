package bootcamp.process.calculator;

import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.data.Status;
import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;

public class Calculator {
    private final ElementFactory factory;

    public Calculator(ElementFactory factory) {
        this.factory = factory;
    }

    public Result calculate(final Params params) {
        Status status;

        Optional<ProcessingElement> element = factory.create(params.getOperator());
        if (element.isEmpty()) {
            return new Result(Status.INVALID_OPERATION, "Invalid operation", Optional.empty());
        } else {
            try {
                BigDecimal value = element.get().process(params.getX(), params.getY());
                return new Result(Status.SUCCESS, "Here is your result:", Optional.ofNullable(value));
            } catch (ArithmeticException exception) {
                return new Result(Status.ARITHMETIC_ERROR, exception.getMessage(), Optional.empty());
            }
        }
    }
}

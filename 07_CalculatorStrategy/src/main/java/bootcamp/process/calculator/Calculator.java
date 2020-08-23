package bootcamp.process.calculator;

import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.data.Status;
import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;
import bootcamp.process.element.impl.Adder;

import java.math.BigDecimal;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;


public class Calculator {
    private final ElementFactory factory;

    public Calculator(ElementFactory factory) {
        this.factory = factory;
    }

    public Result calculate(Params params) {
        Status status;
        String statusMessage;
        Optional<BigDecimal> value = Optional.empty();
        Optional<ProcessingElement> processEl = factory.create(params.getOperator());
        try {
            status = Status.SUCCESS;
            statusMessage = "Here is your result:";
            value = Optional.ofNullable(processEl.get().process(params.getX(), params.getY()));
        } catch (ArithmeticException exception) {
            status = Status.ARITHMETIC_ERROR;
            statusMessage = exception.getMessage();
        } catch (NoSuchElementException exception) {
            status = Status.INVALID_OPERATION;
            statusMessage = exception.getMessage();
        }
        return new Result(status, statusMessage, value);
    }
}
